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
    BinNode<Integer> left = new BinNode<>(1);
    BinNode<Integer> right = new BinNode<>(2);
    root.setLeft(left);
    root.setRight(right);
    BinNode<Integer> more = new BinNode<>(root, 3, root);
    BinNode<Integer> aaa = new BinNode<>(root, 4, more);
    System.out.println(visualize(aaa));
  }
}
