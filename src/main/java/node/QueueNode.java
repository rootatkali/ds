package node;

import DS.Node;
import DS.Queue;
import queue.QueueUtils;

public class QueueNode {
  private static boolean isPrime(int n) {
    if (n <= 1) return false;
    if (n == 2) return true;
    if (n % 2 == 0) return false;
    
    for (int i = 3; i <= n / 2; i+= 2) {
      if (n % i == 0) return false;
    }
    
    return true;
  }
  
  private static int maxInQueue(Queue<Integer> q) {
    q.insert(null);
    int max = -1;
    
    while (q.head() != null) {
      if (isPrime(q.head())) {
        max = Math.max(max, q.head());
      }
      q.insert(q.remove());
    }
    
    return max;
  }
  
  public static int maxPrime(Node<Queue<Integer>> lst) {
    int max = -1;
    
    while (lst != null) {
      if (lst.getValue() != null) {
        max = Math.max(max, maxInQueue(lst.getValue()));
      }
      lst = lst.getNext();
    }
    
    return max;
  }
  
  public static void main(String[] args) {
    Node<Queue<Integer>> lst = NodeUtils.newFrom(
        QueueUtils.newFrom(3, 4, 1, 5, 7, 9, 13, 27, 29),
        null,
        QueueUtils.newFrom(4, 5, 31, 1, 2, 3, 4, 5, 5, 6, 31),
        QueueUtils.newFrom(-1),
        null,
        QueueUtils.newFrom(101, 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90)
    );
    System.out.println(maxPrime(lst));
  }
  
  /*
   * Define n = lst.length. Assume queue.length ~= lst.length.
   * n is not bound.
   * Define m = each number's length. m is not bound.
   * Total complexity: O(n^2*m)
   */
}
