package node;
import DS.Node;

import java.util.Objects;

public class NodeUtils {
  @SafeVarargs
  public static <T> Node<T> newFrom(T... vals) {
    Node<T> head = new Node<>(vals[vals.length - 1]);
    for (int i = vals.length - 2; i >= 0; i--) {
      head = new Node<>(vals[i], head);
    }
    return head;
  }
  
  public static <T> String toString(Node<T> head) {
    String ret = head.toString();
    while (head.hasNext()) {
      head = head.getNext();
      ret += head;
    }
    return ret;
  }
  
  public static <T> int size(Node<T> head) {
    Node<T> crt = head;
    int size = 0;
    while (crt != null) {
      size++;
      crt = crt.getNext();
    }
    return size;
  }
  
  public static <T> int sizeR(Node<T> head) {
    if (head == null) return 0;
    return 1 + sizeR(head.getNext());
  }
  
  public static <T> boolean contains(Node<T> list, T val) {
    Node<T> head = list;
    while (head != null) {
      if (Objects.equals(val, head.getValue())) return true;
      head = head.getNext();
    }
    return false;
  }
  
  public static <T> void insertAfter(Node<T> aft, Node<T> lst) {
    Node<T> next = lst.getNext();
    Node<T> last = aft;
    while (aft.hasNext()) {
      last = last.getNext();
    }
    last.setNext(next);
    lst.setNext(aft);
  }
  
  public static Node<Integer> randList(int length, int from, int to) {
    Integer[] arr = new Integer[length];
    for (int i = 0; i < length; i++) {
      arr[i] = (int) (Math.random() + (to - from + 1)) + to;
    }
    return newFrom(arr);
  }
}
