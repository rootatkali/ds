package DS;

public class Node<T> {
  private T value;
  private Node<T> next;
  
  public Node(T value) {
    this(value, null);
  }
  
  public Node(T value, Node<T> next) {
    this.value = value;
    this.next = next;
  }
  
  public T getValue() {
    return value;
  }
  
  public void setValue(T value) {
    this.value = value;
  }
  
  public boolean hasNext() {
    return next != null;
  }
  
  public Node<T> getNext() {
    return next;
  }
  
  public void setNext(Node<T> next) {
    this.next = next;
  }
  
  @Override
  public String toString() {
    return String.format("%s-->", value);
  }
}
