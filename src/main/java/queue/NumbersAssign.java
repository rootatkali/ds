package queue;

import DS.Queue;

import java.util.Arrays;

public class NumbersAssign {
  public static Queue<Integer> genQueue() {
    int n = (int) (Math.random() * 100) + 100;
    Queue<Integer> ret = new Queue<>();
    for (int i = 0; i < n; i++) {
      ret.insert((int) (Math.random() * 10000) + 10000);
    }
    return ret;
  }
  
  private static int sum(int n) {
    int sum = 0;
    while (n > 0) {
      sum += n % 10;
      n /= 10;
    }
    return sum;
  }
  
  public static void reduceQueue(Queue<Integer> q) {
    q.insert(null);
    while (q.head() != null) {
      q.insert(sum(q.remove()) % 10);
    }
    q.remove();
  }
  
  public static int max(Queue<Integer> q) {
    int[] cnt = new int[10];
    Arrays.fill(cnt, 0);
    
    while (!q.isEmpty()) {
      cnt[q.remove()]++;
    }
    
    int max = cnt[0];
    int maxIdx = 0;
    int mx2i = 0;
    for (int i = 0; i < 10; i++) {
      if (cnt[i] > max) {
        mx2i = maxIdx;
        max = cnt[i];
        maxIdx = i;
      }
    }
    
    return mx2i;
  }
  
  public static void main(String[] args) {
    Queue<Integer> q = genQueue();
    reduceQueue(q);
    System.out.println(max(q));
  }
}
