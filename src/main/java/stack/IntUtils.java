package stack;

import DS.Stack;

public class IntUtils {
  public static Integer min(Stack<Integer> s) {
    Integer min = null;
    Stack<Integer> copy = StackUtils.copy(s);
    while (!copy.isEmpty()) {
      Integer top = copy.pop();
      if (top != null && min == null) min = top;
      else if (top != null) min = Math.min(min, top);
    }
    return min;
  }
  
  public static Integer max(Stack<Integer> s) {
    Integer max = null;
    Stack<Integer> copy = StackUtils.copy(s);
    while (!copy.isEmpty()) {
      Integer top = copy.pop();
      if (top != null && max == null) max = top;
      else if (top != null) max = Math.max(max, top);
    }
    return max;
  }
  
  public static int sum(Stack<Integer> s) {
    Stack<Integer> copy = StackUtils.copy(s);
    int sum = 0;
    
    while (!copy.isEmpty()) {
      sum += copy.top() != null ? copy.pop() : 0;
    }
    
    return sum;
  }
  
  public static int occInStack(Stack<Integer> s, int val) {
    Stack<Integer> tmp = new Stack<>();
    int count = 0;
    
    while (!s.isEmpty()) {
      if (s.top() == val) count++;
      tmp.push(s.pop());
    }
    
    while (!tmp.isEmpty()) {
      s.push(tmp.pop());
    }
    
    return count;
  }
  
  public static Integer rem1FromStk(Stack<Integer> s, int val) {
    Stack<Integer> tmp = new Stack<>();
    boolean out = false;
    
    while (!(s.isEmpty() || out)) {
      if (s.top() == val) {
        out = true;
        s.pop();
      } else {
        tmp.push(s.pop());
      }
    }
  
    while (!tmp.isEmpty()) {
      s.push(tmp.pop());
    }
    
    return val;
  }
  
  public static Stack<Integer> sort(Stack<Integer> s) {
    Stack<Integer> tmp = StackUtils.copy(s), ret = new Stack<>();
    
    while (!tmp.isEmpty()) {
      ret.push(rem1FromStk(tmp, min(tmp)));
    }
    
    return ret;
  }
  
  public static Stack<Integer> sumTopBottom(Stack<Integer> s) {
    Stack<Integer> tmp1 = new Stack<>();
    Stack<Integer> tmp2 = new Stack<>();
    Stack<Integer> ret = new Stack<>();
    
    while (!s.isEmpty()) {
      tmp2.push(s.top());
      int top = s.pop();
      StackUtils.move(s, tmp1);
      int bot = 0;
      if (!tmp1.isEmpty()) bot = tmp1.pop();
      StackUtils.move(tmp1, s);
      ret.push(top + bot);
    }
    
    StackUtils.move(tmp2, s);
    
    return ret;
  }
}
