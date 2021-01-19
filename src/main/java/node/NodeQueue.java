package node;

import DS.Node;
import DS.Queue;
import queue.QueueUtils;

public class NodeQueue {
  private static boolean isPrime(int n) {
    if (n <= 0) return false;
    if (n == 1 || n == 2) return true;
    if (n % 2 == 0) return false;
    
    for (int i = 3; i <= n / 2; i+= 2) {
      if (n % i == 0) return false;
    }
    
    return true;
  }
  
  private static int maxInNode(Node<Integer> lst) {
    int max = -1;
    
    while (lst != null) {
      if (isPrime(lst.getValue())) {
        max = Math.max(lst.getValue(), max);
      }
      lst = lst.getNext();
    }
    
    return max;
  }
  
  public static int maxPrime(Queue<Node<Integer>> q) {
    int max = -1;
    
    Queue<Node<Integer>> tmp = new Queue<>();
    while (!q.isEmpty()) {
      if (q.head() != null) {
        max = Math.max(max, maxInNode(q.head()));
      }
      tmp.insert(q.remove());
    }
    
    while (!tmp.isEmpty()) q.insert(tmp.remove());
    
    return max;
  }
  
  public static void main(String[] args) {
    Queue<Node<Integer>> q = QueueUtils.newFrom(
        NodeUtils.newFrom(3, 4, 1, 5, 7, 9, 13, 27, 29),
        null,
        NodeUtils.newFrom(4, 5, 31, 1, 2, 3, 4, 5, 5, 6, 31),
        NodeUtils.newFrom(-2),
        null,
        NodeUtils.newFrom(101, 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90)
    );
    System.out.println(maxPrime(q));
  }
  
  // Same complexity as QueueNode
}
