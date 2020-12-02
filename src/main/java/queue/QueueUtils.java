package queue;

import DS.Queue;
import DS.Stack;

import java.util.Objects;

public class QueueUtils {
  @SafeVarargs
  public static <T> Queue<T> newFrom(T... vals) {
    Queue<T> ret = new Queue<>();
    
    for (T t : vals) {
      ret.insert(t);
    }
    
    return ret;
  }
  
  public static <T> void move(Queue<T> src, Queue<T> dst) {
    while (!src.isEmpty()) {
      dst.insert(src.remove());
    }
  }
  
  public static <T> Queue<T> copy(Queue<T> q) {
    Queue<T> tmp = new Queue<>();
    Queue<T> ret = new Queue<>();
    while (!q.isEmpty()) {
      tmp.insert(q.head());
      ret.insert(q.remove());
    }
    move(tmp, q);
    return ret;
  }
  
  public static <T> int length(Queue<T> q) {
    Queue<T> tmp = new Queue<>();
    int len = 0;
    while (!q.isEmpty()) {
      len++;
      tmp.insert(q.remove());
    }
    
    move(tmp, q);
    return len;
  }
  
  public static int occInQueue(Queue<Integer> q, int val) {
    Queue<Integer> tmp = new Queue<>();
    int cnt = 0;
    while (!q.isEmpty()) {
      if (q.head() == val) cnt++;
      tmp.insert(q.remove());
    }
    move(tmp, q);
    return cnt;
  }
  
  public static <T> boolean contains(Queue<T> q, T val) {
    boolean found = false;
    Queue<T> tmp = new Queue<>();
    while (!q.isEmpty()) {
      if (Objects.equals(val, q.head())) found = true;
      tmp.insert(q.remove());
    }
    move(tmp, q);
    return found;
  }
  
  public static boolean contains(Queue<Integer> q, int val) {
    return occInQueue(q, val) > 0;
  }
  
  public static <T> void reverse(Queue<T> q) {
    if (q.isEmpty()) return;
    T tmp = q.remove();
    reverse(q);
    q.insert(tmp);
  }
  
  public static Integer min(Queue<Integer> q) {
    q.insert(null);
    Integer min = q.head();
    while (q.head() != null) {
      int val = q.remove();
      min = Math.min(val, min);
      q.insert(val);
    }
    q.remove(); // Clear null key
    return min;
  }
  
  public static Integer remOne(Queue<Integer> q, int val) {
    q.insert(null);
    Integer rem = null;
    while (q.head() != null) {
      if (q.head() == val && rem == null) {
        rem = q.remove();
      } else {
        q.insert(q.remove());
      }
    }
    q.remove(); // Clear null key
    return rem;
  }
  
  public static void sort(Queue<Integer> q) {
    Queue<Integer> tmp = new Queue<>();
    while (!q.isEmpty()) {
      tmp.insert(remOne(q, min(q)));
    }
    move(tmp, q);
  }
  /** assumes both a and b are sorted */
  public static void merge(Queue<Integer> a, Queue<Integer> b) {
    Queue<Integer> tmp = new Queue<>();
    
    while (!(a.isEmpty() || b.isEmpty())) {
      if (a.head() < b.head()) {
        tmp.insert(a.remove());
      } else {
        tmp.insert(b.remove());
      }
    }
    
    if (a.isEmpty()) {
      move(b, tmp);
    } else {
      move (a, tmp);
    }
    
    move (tmp, a);
  }
  
  public static boolean isPal(Queue<Integer> q) {
    Queue<Integer> copy = copy(q);
    reverse(copy);
    boolean ret = true;
    
    q.insert(null);
    while (q.head() != null) {
      Integer tmp = q.remove();
      if (!tmp.equals(copy.remove())) ret = false;
      q.insert(tmp);
    }
    q.remove();
    return ret;
  }
  
  public static int numQ(Queue<Integer> q) {
    q.insert(null);
    int pow = 0;
    int ret = 0;
    while (q.head() != null) {
      Integer tmp = q.remove();
      ret += tmp * Math.pow(10, pow++);
      q.insert(tmp);
    }
    q.remove();
    return ret;
  }
}
