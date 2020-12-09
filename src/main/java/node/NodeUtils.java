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
  
  public static <T> Node<T> getLast(Node<T> head) {
    while (head.hasNext()) {
      head = head.getNext();
    }
    
    return head;
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
  
  public static Node<Integer> findMinP(Node<Integer> lst) {
    Node<Integer> min = lst;
    while (lst.hasNext()) {
      if (lst.getNext().getValue() < min.getValue()) {
        min = lst.getNext();
      }
      lst = lst.getNext();
    }
    return min;
  }
  
  public static int findMinV(Node<Integer> lst) {
    return findMinP(lst).getValue();
  }
  
  public static <T> Node<T> insertBefore(Node<T> fst, Node<T> be, Node<T> pt) {
    boolean ins = false;
    if (fst == be) {
      pt.setNext(fst);
      return pt;
    }
    
    Node<T> head = fst;
    while (!ins && fst.hasNext()) {
      if (fst.getNext() == be) {
        ins = true;
        pt.setNext(be);
        fst.setNext(pt);
      }
      fst = fst.getNext();
    }
    return head;
  }
  
  public static <T> Node<T> remove(Node<T> fst, Node<T> pt) {
    Node<T> head = fst;
    if (fst == pt) {
      return fst.getNext();
    }
    while (fst != null) {
      if (fst.getNext() == pt) {
        fst.setNext(pt.getNext());
      }
      fst = fst.getNext();
    }
    return head;
  }
  
  public static Node<Integer> sort(Node<Integer> fst) {
    Node<Integer> head = findMinP(fst);
    fst = remove(fst, findMinP(fst));
    Node<Integer> last = head;
    while (fst != null) {
      last.setNext(findMinP(fst));
      last = last.getNext();
      fst = remove(fst, findMinP(fst));
    }
    
    return head;
  }
  
  public static <T> Node<T> mergeNotSorted(Node<T> a, Node<T> b) {
    getLast(a).setNext(b);
    return a;
  }
  
  public static Node<Integer> mergeSorted(Node<Integer> a, Node<Integer> b) {
    Node<Integer> head;
    if (a.getValue() < b.getValue()) {
      head = a;
      a = a.getNext();
    } else {
      head = b;
      b = b.getNext();
    }
    
    Node<Integer> last = head;
    
    while (a != null && b != null) {
      if (a.getValue() < b.getValue()) {
        last.setNext(a);
        a = a.getNext();
      } else {
        last.setNext(b);
        b = b.getNext();
      }
    }
    
    if (a == null) return mergeNotSorted(head, b);
    return mergeNotSorted(head, a);
  }
  
  public static void removeDups(Node<Integer> fst) {
    while (fst != null && fst.hasNext()) {
      if (fst.getValue() == fst.getNext().getValue()) {
        fst.setNext(fst.getNext().getNext());
      } else fst = fst.getNext();
    }
  }
  
  public static Node<Integer> randList(int length, int from, int to) {
    Integer[] arr = new Integer[length];
    for (int i = 0; i < length; i++) {
      arr[i] = (int) (Math.random() + (to - from + 1)) + to;
    }
    return newFrom(arr);
  }
  
  public static void main(String[] args) {
    Node<Integer> lst = newFrom(1, 5, 2, 3, 4, 4, 6, 4);
    System.out.println(toString(sort(lst)));
    removeDups(lst);
    System.out.println(toString(lst));
  }
}
