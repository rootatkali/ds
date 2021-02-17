package bin;

import DS.BinNode;
import static bin.TreeUtils.*;
public class Test {
  
  public static void main(String[] args) {
    BinNode<Integer> aaa = genTree(15, 0, 100);
//    while (countLeaves(aaa) != 8) aaa = genTree(15, 0, 2);
    Printer.printTree(aaa);
    System.out.println(contains(aaa, 69));
  }
}
