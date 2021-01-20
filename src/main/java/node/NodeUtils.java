package node;

import DS.Node;
import DS.Queue;
import queue.QueueUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class NodeUtils {
  
  @SafeVarargs
  public static <T> Node<T> newFrom(T... vals) {
    // Creates a list of nodes from an array/vararg of values
    Node<T> head = new Node<>(vals[vals.length - 1]);
    for (int i = vals.length - 2; i >= 0; i--) {
      head = new Node<>(vals[i], head);
    }
    return head;
  }
  
  public static <T> String stringify(Node<T> head) {
    if (head == null) return "null";
    
    StringBuilder ret = new StringBuilder(head.toString());
    while (head.hasNext()) {
      head = head.getNext();
      ret.append(head);
    }
    return ret.toString();
  }
  
  public static <T> Node<T> copy(Node<T> head) {
    Node<T> ret = new Node<>(head.getValue());
    Node<T> last = ret;
    while (head.hasNext()) {
      last.setNext(new Node<>(head.getNext().getValue()));
      head = head.getNext();
      last = last.getNext();
    }
    return ret;
  }
  
  public static <T> Node<T> getLast(Node<T> head) {
    while (head.hasNext()) {
      head = head.getNext();
    }
    
    return head;
  }
  
  public static <T> Node<T> getNode(Node<T> head, int index) {
    for (int i = 0; i < index; i++) {
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
  
  public static <T> boolean equals(Node<T> a, Node<T> b) {
    if (a == b) return true;
    
    while (a != null && b != null) {
      if (!Objects.equals(a.getValue(), b.getValue())) return false;
      a = a.getNext();
      b = b.getNext();
    }
    
    return a == null && b == null;
  }
  
  public static <T> boolean contains(Node<T> list, T val) {
    Node<T> head = list;
    while (head != null) {
      if (Objects.equals(val, head.getValue())) return true;
      head = head.getNext();
    }
    return false;
  }
  
  public static <T> List<T> toArrayList(Node<T> lst) {
    List<T> ret = new ArrayList<>();
    while (lst != null) {
      ret.add(lst.getValue());
      lst = lst.getNext();
    }
    return ret;
  }
  
  public static <T> boolean isLoop(Node<T> lst) {
    Queue<Node<T>> store = new Queue<>();
    while (lst != null) {
      if (QueueUtils.containsReference(store, lst)) return true;
      store.insert(lst);
      lst = lst.getNext();
    }
    return false;
  }
  
  public static <T> Stream<T> toStream(Node<T> lst) {
    return toArrayList(lst).stream();
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
    // Selection sort for list of nodes
    
    Node<Integer> head = findMinP(fst);
    Node<Integer> last = head;
    
    fst = remove(fst, head);
    while (fst != null) {
      last.setNext(findMinP(fst));
      last = last.getNext();
      fst = remove(fst, findMinP(fst));
    }
    
    return head;
  }
  
  // assumes a isn't null
  public static <T> Node<T> mergeNotSorted(Node<T> a, Node<T> b) {
    getLast(a).setNext(b);
    return a;
  }
  
  // assumes both a and b aren't null
  public static Node<Integer> mergeSorted(Node<Integer> a, Node<Integer> b) {
    Node<Integer> head;
    
    // Get first element
    if (a.getValue() < b.getValue()) {
      head = a;
      a = a.getNext();
    } else {
      head = b;
      b = b.getNext();
    }
    
    Node<Integer> last = head;
    
    // Loop until one list is finished
    while (a != null && b != null) {
      if (a.getValue() < b.getValue()) {
        last.setNext(a);
        a = a.getNext();
      } else {
        last.setNext(b);
        b = b.getNext();
      }
      last = last.getNext();
    }
    // Append remainder of other list to end
    if (a == null) return mergeNotSorted(head, b);
    return mergeNotSorted(head, a);
  }
  
  // Requires sorted list
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
}
