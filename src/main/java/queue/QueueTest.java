package queue;

import DS.Queue;

import static queue.QueueUtils.*;

public class QueueTest {
  public static void main(String[] args) {
    Queue<Integer> q = newFrom(7, 4, 6, 2, 8, 5, 4);
    System.out.println(q);
//    QueueUtils.sort(q);
//    System.out.println(q);
    System.out.println(isPal(q));
    System.out.println(isPal(newFrom(1, 2, 3, 4, 3 ,2 ,1)));
    System.out.println("----------");
    System.out.println(numQ(q));
  }
}
