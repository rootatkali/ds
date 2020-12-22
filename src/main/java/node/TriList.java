package node;

import DS.Node;

import static node.NodeUtils.*;

public class TriList {
  public static boolean isTriList(Node<Integer> list) {
    int length = size(list);
    if (length % 3 != 0) return false;
    
    Node<Integer> a = list;
    Node<Integer> b = getNode(list, length / 3);
    Node<Integer> c = getNode(list, 2 * length / 3);
    
    for (int i = 0; i < length / 3; i++) {
      if (a.getValue() != b.getValue() || a.getValue() != c.getValue()) return false;
      a = a.getNext();
      b = b.getNext();
      c = c.getNext();
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    Node<Integer> triList = newFrom(1, 2, 3, 1, 2, 3, 1, 2, 3);
    Node<Integer> notTriList = newFrom(1, 2, 3, 1, 2, 4, 1, 2, 3);
    System.out.println(isTriList(triList));
    System.out.println(isTriList(notTriList));
  }
}
