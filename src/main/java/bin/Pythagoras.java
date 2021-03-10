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
    return isBig(ptr) && // check for both children existing, assumes values != null
        isPitag3(ptr.getValue(), ptr.getLeft().getValue(), ptr.getRight().getValue());
  }
  
  public static boolean isPitagTree(BinNode<Integer> tree) {
    if (!twoOrZeroSons(tree)) return false;
    return isPitag3(tree) && isPitag3(tree.getLeft()) && isPitag3(tree.getRight());
  }
  
  public static void main(String[] args) {
    
  }
}
