package node;

import DS.Node;

public class Main {
  public static void main(String[] args) {
    Node<Integer> lst = NodeUtils.newFrom(1, 5, 2, 3, 4, 4, 6, 4);
    lst = NodeUtils.sort(lst);
    System.out.println(NodeUtils.toString(lst));
    Node<Integer> lst2 = NodeUtils.newFrom(1, 2, 3, 4, 6, 10);
    System.out.println(NodeUtils.toString(NodeUtils.mergeSorted(lst, lst2)));
  }
}
