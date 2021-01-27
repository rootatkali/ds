package tests;

import DS.Node;
import node.NodeUtils;

public class GeneralTst2 {
  public static int listToNum(Node<Integer> lst) {
    if (lst == null || lst.getValue() == null) return -1;
    int num = 0;
    int power = 0;
    
    while (lst != null) {
      num += lst.getValue() * Math.pow(10, power++);
      lst = lst.getNext();
    }
    
    return num;
  }
  
  public static int maxInList(Node<Node<Integer>> lst) {
    int max = -1;
    while (lst != null) {
      max = Math.max(max, listToNum(lst.getValue()));
      lst = lst.getNext();
    }
    return max;
  }
  
  public static void main(String[] args) {
    Node<Node<Integer>> lst = NodeUtils.newFrom(
        NodeUtils.newFrom(2, 6),
        NodeUtils.newFrom(7, 2, 4),
        NodeUtils.newFrom(8, 2),
        new Node<>(null),
        NodeUtils.newFrom(1, 6, 9),
        NodeUtils.newFrom(3)
    );
  
    System.out.println(maxInList(lst));
  }
}
