package bin;

import DS.BinNode;

import static bin.TreeUtils.*;

public class Pythagoras {
  private static boolean isOrderedP(int a, int b, int c) {
    return a * a + b * b == c * c;
  }
  
  public static boolean isPitag3(int n1, int n2, int n3) {
    return isOrderedP(n1, n2, n3) || isOrderedP(n2, n3, n1) || isOrderedP(n3, n1, n2);
  }
  
  public static boolean isPitag3(BinNode<Integer> ptr) {
    if (ptr == null || isLeaf(ptr)) return true;
    return isBig(ptr) && // check for both children existing, assumes values != null
        isPitag3(ptr.getValue(), ptr.getLeft().getValue(), ptr.getRight().getValue());
  }
  
  public static boolean isPitagTree(BinNode<Integer> tree) {
    return isPitag3(tree) &&
        (!tree.hasLeft() || isPitagTree(tree.getLeft())) &&
        (!tree.hasRight() || isPitagTree(tree.getRight()));
  }
  
  public static void main(String[] args) {
    BinNode<Integer> pyt = SearchTreeUtils.genSearchTree(12, 13, 5, 3);
    pyt.getLeft().setRight(new BinNode<>(4));
    Printer.printTree(pyt);
    System.out.println(isPitagTree(pyt));
  }
}
