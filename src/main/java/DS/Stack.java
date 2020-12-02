package DS;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
  private final List<T> list;
  
  public Stack() {
    list = new ArrayList<>();
  }
  
  public void push(T val) {
    list.add(0, val);
  }
  
  public T pop() {
    return list.remove(0);
  }
  
  public T top() {
    return list.get(0);
  }
  
  public boolean isEmpty() {
    return list.isEmpty();
  }
  
  public String toString() {
    return list.toString();
  }
}
