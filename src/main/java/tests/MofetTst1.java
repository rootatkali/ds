package tests;

import DS.Queue;
import DS.Stack;
import queue.QueueUtils;

public class MofetTst1 {
  
  public static Stack<Character> que2Stk(Queue<Character> que) {
    Queue<Character> tmp = new Queue<>();
    Stack<Character> lrg = new Stack<>(), ret = new Stack<>();
    int cnt = 0, max = 0; // cnt - temp queue length, max - longest queue to date
    char current; // Current char, for iterating over queue
    
    while (!que.isEmpty()) { // Iterate over queue
      current = que.remove();
      if (current == '#' || que.isEmpty()) { // Separator
        if (que.isEmpty()) { // If last character and no separator, add last to tmp before comparing
          cnt++;
          tmp.insert(current);
        }
        
        if (cnt > max) { // If largest sub-queue
          max = cnt; // Update max
          while (!lrg.isEmpty()) lrg.pop(); // reset largest stack
          while (!tmp.isEmpty()) lrg.push(tmp.remove()); // Move to largest, this resets tmp
        } else while (!tmp.isEmpty()) tmp.remove(); // If not largest, reset tmp
        
        cnt = 0; // Reset count
        
      } else { // Add to tmp queue if not '#'
        cnt++;
        tmp.insert(current);
      }
    }
    
    // After loop is finished, move lrg to ret and return
    while (!lrg.isEmpty()) {
      ret.push(lrg.pop());
    }
    return ret;
  }
  
  public static void main(String[] args) {
    Queue<Character> tst = QueueUtils.newFrom(
        '1', '2', '3', '4', '#',
        '1', '2', '3', '#',
        '1', '2', '3', '4', '5'
    );
    
    System.out.println(que2Stk(tst));
    
    Queue<Character> t2 = QueueUtils.newFrom('#', 'x', 'x', 'x', '#', 'x', 'x', '#');
    System.out.println(que2Stk(t2));
  }
}
