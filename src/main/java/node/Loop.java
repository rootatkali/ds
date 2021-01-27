package node;

import DS.Node;

import java.util.HashMap;

public class Loop {
  public static Node<Integer> genNode() {
    Node<Integer> node = NodeUtils.randList(100, 0, 100);
    NodeUtils.getLast(node).setNext(NodeUtils.getNode(node, (int) (Math.random() * 61) + 20));
    return node;
  }
  
  // Uses external data structure
  public static boolean isLoop1(Node<Integer> lst) {
    int loops = 0;
    HashMap<Node<Integer>, Integer> heap = new HashMap<>();
    
    while (lst != null) {
      loops++;
      if (heap.containsKey(lst)) { // HashMap.containsKey has an average complexity of 1
        System.out.printf("Loops: %d, list original length: 100%n", loops);
        return true;
      }
      heap.put(lst, 1);
      lst = lst.getNext();
    }
    
    System.out.printf("Loops: %d, list original length: 100%n", loops);
    return false;
  }
  
  // Uses "flag" null value
  public static boolean isLoop2(Node<Integer> lst) {
    int loops = 0;
    
    while (lst != null) {
      loops++;
      if (lst.getValue() == null) {
        System.out.printf("Loops: %d, list original length: 100%n", loops);
        return true;
      }
      lst.setValue(null);
      lst = lst.getNext();
    }
  
    System.out.printf("Loops: %d, list original length: 100%n", loops);
    return false;
  }
  
  public static void loopForMethod1() {
    for (int i = 0; i < 100; i++) {
      System.out.printf("Run #%d%n", i + 1);
      System.out.println(isLoop1(genNode()));
    }
  }
  
  public static void loopForMethod2() {
    for (int i = 0; i < 100; i++) {
      System.out.printf("Run #%d%n", i + 1);
      System.out.println(isLoop2(genNode()));
    }
  }
  
  public static void main(String[] args) {
    loopForMethod1();
    System.out.println("\n---\n");
    loopForMethod2();
  }
}
