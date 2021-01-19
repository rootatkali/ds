package stack;

import DS.Stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StackUtils {
  /**
   * Returns a new stack with the elements of vals, when vals[0] is on the top of the stack
   */
  @SafeVarargs
  public static <T> Stack<T> newFrom(T... vals) {
    Stack<T> ret = new Stack<>();
    for (int i = vals.length - 1; i >= 0; i--) {
      ret.push(vals[i]);
    }
    return ret;
  }
  
  public static <T> Stack<T> copy(Stack<T> s) {
    Stack<T> tmp = new Stack<>(); // temp stack for copy
    Stack<T> ret = new Stack<>(); // return
    
    while (!s.isEmpty()) {
      tmp.push(s.pop());
    }
    
    while (!tmp.isEmpty()) {
      s.push(tmp.top());
      ret.push(tmp.pop());
    }
    
    return ret;
  }
  
  public static <T> int size(Stack<T> s) {
    Stack<T> copy = copy(s);
    int size = 0;
    while (!copy.isEmpty()) {
      s.pop();
      size++;
    }
    return size;
  }
  
  public static <T> boolean exists(Stack<T> s, T val) {
    Stack<T> copy = copy(s);
    while (!copy.isEmpty()) {
      if (Objects.equals(copy.pop(), val)) return true;
    }
    return false;
  }
  
  public static <T> boolean equals(Stack<T> a, Stack<T> b) {
    Stack<T> ac = copy(a), bc = copy(b);
    while (!(ac.isEmpty() || bc.isEmpty())) {
      if (!Objects.equals(ac.pop(), bc.pop())) return false;
    }
    return ac.isEmpty() && bc.isEmpty();
  }
  
  public static <T> void reverse(Stack<T> s) {
    Stack<T> tmp1 = new Stack<>(), tmp2 = new Stack<>();
    move(s, tmp1);
    move(tmp1, tmp2);
    move(tmp2, s);
  }
  
  public static <T> void move(Stack<T> from, Stack<T> to) {
    while (!from.isEmpty()) {
      to.push(from.pop());
    }
  }
  
  public static <T> void clear(Stack<T> s) {
    while (!s.isEmpty()) {
      s.pop();
    }
  }
}
