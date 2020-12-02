package bin;

import DS.BinNode;

public class Test {
  public static <T> String visualize(BinNode<T> tree) {
    StringBuilder sb = new StringBuilder();
    
    if (tree.hasLeft()) {
      String top = visualize(tree.getLeft());
      String[] lines = top.split("\n");
      for (String line: lines) {
        sb.append("  ").append(line).append("\n");
      }
    }
    sb.append(tree.getValue());
    if (tree.hasRight()) {
      String bottom = visualize(tree.getRight());
      for (String line : bottom.split("\n")) {
        sb.append("\n  ").append(line);
      }
    }
    
    return sb.toString();
  }
  
  public static void main(String[] args) {
    BinNode<Integer> root = new BinNode<>(0);
    BinNode<Integer> top = new BinNode<>(1);
    BinNode<Integer> bot = new BinNode<>(2);
    root.setLeft(top);
    root.setRight(bot);
    BinNode<Integer> more = new BinNode<>(root, 3, root);
    System.out.println(visualize(more));
  }
}
