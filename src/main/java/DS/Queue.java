package DS;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
  private final List<T> list;
  
  public Queue() {
    list = new ArrayList<>();
  }
  
  public void insert(T val) {
    list.add(val);
  }
  
  public T remove() {
    return list.remove(0);
  }
  
  public T head() {
    return list.get(0);
  }
  
  public boolean isEmpty() {
    return list.isEmpty();
  }
  
  public String toString() {
    return list.toString();
  }
}
