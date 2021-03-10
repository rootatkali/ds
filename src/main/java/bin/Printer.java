package bin;

import DS.BinNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Printer {
  public static <T> void printTree(BinNode<T> root) {
    int maxLevel = Printer.maxLevel(root);
    
    printTreeInternal(Collections.singletonList(root), 1, maxLevel);
  }
  
  private static <T> void printTreeInternal(List<BinNode<T>> nodes, int level, int maxLevel) {
    if (nodes.isEmpty() || Printer.isAllElementsNull(nodes))
      return;
    
    int floor = maxLevel - level;
    int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
    int firstSpaces = (int) Math.pow(2, (floor)) - 1;
    int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
    
    Printer.printWhitespaces(firstSpaces);
    
    List<BinNode<T>> newNodes = new ArrayList<>();
    for (BinNode<T> node : nodes) {
      if (node != null) {
        System.out.print(node.getValue());
        newNodes.add(node.getLeft());
        newNodes.add(node.getRight());
      } else {
        newNodes.add(null);
        newNodes.add(null);
        System.out.print(" ");
      }
      
      Printer.printWhitespaces(betweenSpaces);
    }
    System.out.println();
    
    for (int i = 1; i <= edgeLines; i++) {
      for (int j = 0; j < nodes.size(); j++) {
        Printer.printWhitespaces(firstSpaces - i);
        if (nodes.get(j) == null) {
          Printer.printWhitespaces(edgeLines + edgeLines + i + 1);
          continue;
        }
        
        if (nodes.get(j).hasLeft())
          System.out.print("/");
        else
          Printer.printWhitespaces(1);
        
        Printer.printWhitespaces(i + i - 1);
        
        if (nodes.get(j).hasRight())
          System.out.print("\\");
        else
          Printer.printWhitespaces(1);
        
        Printer.printWhitespaces(edgeLines + edgeLines - i);
      }
      
      System.out.println();
    }
    
    printTreeInternal(newNodes, level + 1, maxLevel);
  }
  
  private static void printWhitespaces(int count) {
    for (int i = 0; i < count; i++)
      System.out.print(" ");
  }
  
  private static <T> int maxLevel(BinNode<T> node) {
    if (node == null)
      return 0;
    
    return Math.max(Printer.maxLevel(node.getLeft()), Printer.maxLevel(node.getRight())) + 1;
  }
  
  private static <T> boolean isAllElementsNull(List<T> list) {
    for (Object object : list) {
      if (object != null)
        return false;
    }
    
    return true;
  }
}
