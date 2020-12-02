package queue;

import DS.Queue;

public class Set {
  private Queue<Integer> queue;
  
  public Set() {
    queue = new Queue<>();
  }
  
  private boolean contains(Queue<Integer> queue, int val) {
    queue.insert(null);
    boolean ret = false;
    while (queue.head() != null) {
      if (queue.head() == val) {
        ret = true;
      }
      queue.insert(queue.remove());
    }
    queue.remove();
    return ret;
  }
  
  public boolean add(int value) {
    if (!contains(queue, value)) {
      queue.insert(value);
      return true;
    }
    return false;
  }
  
  public boolean contains(int value) {
    return contains(queue, value);
  }
  
  public Queue<Integer> toQueue() {
    return queue;
  }
  
  public Set union(Set s) {
    Set ret = new Set();
    queue.insert(null);
    while (queue.head() != null) {
      ret.add(queue.head());
      queue.insert(queue.remove());
    }
    queue.remove();
    
    s.queue.insert(null);
    while (s.queue.head() != null) {
      ret.add(s.queue.head());
      s.queue.insert(s.queue.remove());
    }
    s.queue.remove();
    
    return ret;
  }
  
  public Set intersect(Set s) {
    Set ret = new Set();
    
    queue.insert(null);
    while (queue.head() != null) {
      if (contains(s.queue, queue.head())) ret.add(queue.head());
      queue.insert(queue.remove());
    }
    queue.remove();
    
    return ret;
  }
  
  static Set newFrom(int... vals) {
    Set ret = new Set();
    for (int i : vals) {
      ret.add(i);
    }
    return ret;
  }
  
  @Override
  public String toString() {
    return queue.toString();
  }
}
