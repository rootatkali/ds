package node;

import DS.Node;

public class Main {
  public static void main(String[] args) {
    Node<Integer> lst = NodeUtils.newFrom(1, 5, 2, 3, 4, 4, 6, 4);
    System.out.println(NodeUtils.isLoop(lst)); // false
    NodeUtils.getLast(lst).setNext(lst.getNext().getNext());
    System.out.println(NodeUtils.isLoop(lst)); // true
  }
}
