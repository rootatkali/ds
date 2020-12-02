package tests;

import DS.Queue;
import DS.Stack;
import queue.QueueUtils;

public class GiftedTest1 {
  public static boolean isShortPali(Queue<Integer> q, int len) {
    if (len < 2) return false;
    int lenCopy = len;
    
    Queue<Integer> lenQ = new Queue<>();
    Stack<Integer> revQ = new Stack<>();
    
    q.insert(null);
    
    Integer current;
    
    while (q.head() != null) {
      current = q.remove();
      if (lenCopy > 0) {
        lenQ.insert(current);
        revQ.push(current);
        lenCopy--;
      }
      
      q.insert(current);
    }
    
    q.remove();
    
    for (int i = 0; i < len; i++) {
      if (revQ.pop() != lenQ.remove()) return false;
    }
    return true;
  }
  
  public static int maxPaliQ(Queue<Integer> q) {
    int len = 0;
    int max = 0;
    
    q.insert(null);
    while (q.head() != null) {
      len++;
      q.insert(q.remove());
    }
    q.remove();
    
    for (int i = 2; i <= len; i++) {
      if (isShortPali(q, i)) {
        max = i;
      }
    }
    
    return max;
  }
  
  public static void main(String[] args) {
    Queue<Integer> queue = QueueUtils.newFrom(1, 2, 1, 2, 3, 4, 3, 2, 1, 2, 1, 3);
//    System.out.println(isShortPali(queue, 4));
//    System.out.println(maxPaliQ(queue));
    
    Double a = Double.NaN;
    System.out.println(a.equals(a));
    
    
    
    
    
    
    System.out.println("\n\n\n");
  }
}
