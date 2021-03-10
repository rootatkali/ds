package bin;

import DS.BinNode;
import static bin.TreeUtils.*;
import static bin.SearchTreeUtils.*;

public class Test {
  
  public static void main(String[] args) {
    BinNode<Integer> aaa = genTree(15, 0, 4);
    while (cntLvlR(aaa) != 4) aaa = genTree(15, 0, 4);
    Printer.printTree(aaa);
//    System.out.println(contains(aaa, 6));
//    Printer.printTree(findNodeByVal(aaa, 6));
//    System.out.println(cntLvlR(aaa));
    System.out.println(valsAtLevel(aaa, 4));
    BinNode<Integer> bbb = genTree(15, 0, 4);
    System.out.println(containsAll(aaa, bbb));
    System.out.println(containsAll(bbb, aaa));
  
    System.out.println(treeToString(aaa));
  
    System.out.println();
    // ----------
    System.out.println();
    
    BinNode<Integer> st = genSearchTree(4, 6, 2, 3, 5, 87, 2, 4, 6, 1, 0);
    System.out.println(lookup(st, 5));
    System.out.println(lookup(st, 7));
    insert(st, 200);
    Printer.printTree(st);
  }
}
