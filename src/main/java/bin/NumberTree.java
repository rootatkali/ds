package bin;

import DS.BinNode;
import DS.Queue;

public class NumberTree {
  public static void printAll(BinNode<Integer> tree) {
    Queue<String> store = new Queue<>();
    addChildren(tree, "", store);
    while (!store.isEmpty()) {
      System.out.println(store.remove());
    }
  }
  
  private static void addChildren(BinNode<Integer> tree, String prefix, Queue<String> store) { // helper
    if (tree == null) return;
    
    if (!(tree.hasRight() || tree.hasLeft())) { // leaf
      store.insert(prefix + tree.getValue());
    } else {
      if (tree.hasLeft()) {
        addChildren(tree.getLeft(), prefix + tree.getValue(), store);
      }
      
      if (tree.hasRight()) {
        addChildren(tree.getRight(), prefix + tree.getValue(), store);
      }
    }
  }
  
  public static void main(String[] args) {
    BinNode<Integer> tree = TreeUtils.genTree(10, 1, 9);
    Printer.printTree(tree);
    System.out.println();
    printAll(tree);
  }
}
