package set;

import DS.Queue;

public class SetPoint4D {
  private final Queue<Point4D> queue;
  
  public SetPoint4D() {
    queue = new Queue<>();
  }
  
  // returns true if val is in the set
  public boolean contains(Point4D val) {
    boolean is = false;
    
    queue.insert(null);
    while (queue.head() != null) {
      if (queue.head().equals(val)) is = true;
      queue.insert(queue.remove());
    }
    queue.remove();
    
    return is;
  }
  
  // Adds an element to the set if it's not in there. Returns whether the action was successful
  public boolean add(Point4D val) {
    if (val == null || contains(val)) return false;
    queue.insert(new Point4D(val));
    return true;
  }
  
  // Attempts to remove one element from the set. Returns whether successful
  public boolean delete(Point4D val) {
    if (val == null || !contains(val)) return false;
    Point4D current;
    
    queue.insert(null);
    while (queue.head() != null) {
      current = queue.remove();
      if (!current.equals(val)) queue.insert(current);
    }
    queue.remove();
    
    return true;
  }
  
  // Returns a queue containing the elements of the set, in no particular order
  public Queue<Point4D> toQueue() {
    Queue<Point4D> ret = new Queue<>();
    
    queue.insert(null);
    while (queue.head() != null) {
      ret.insert(new Point4D(queue.head()));
      queue.insert(queue.remove());
    }
    queue.remove();
    
    return ret;
  }
  
  @Override
  public String toString() {
    return queue.toString();
  }
  
  // True if a in b and b in a
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SetPoint4D s = (SetPoint4D) o;
    
    boolean in = true;
    
    Queue<Point4D> thisQ = toQueue();
    
    while (!thisQ.isEmpty()) {
      in = in && s.contains(thisQ.head());
      thisQ.remove();
    }
    
    if (!in) return false;
    
    Queue<Point4D> thatQ = s.toQueue();
    
    while (!thatQ.isEmpty()) {
      in = in && this.contains(thatQ.head());
      thatQ.remove();
    }
    
    return in;
  }
}
