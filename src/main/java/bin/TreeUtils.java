package bin;

import DS.BinNode;

import java.util.Arrays;
import java.util.Objects;

public class TreeUtils {
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
  
  public static int sum(BinNode<Integer> tree) {
    if (tree == null) return 0;
    return sum(tree.getLeft()) + tree.getValue() + sum(tree.getRight());
  }
  
  public static <T> boolean isLeaf(BinNode<T> tree) {
    return tree != null && !(tree.hasLeft() || tree.hasRight());
  }
  
  public static <T> int countLeaves(BinNode<T> tree) {
    if (tree == null) return 0;
    if (isLeaf(tree)) return 1;
    return countLeaves(tree.getLeft()) + countLeaves(tree.getRight());
  }
  
  private static int rand(int lo, int hi) {
    return (int) (Math.random() * (hi - lo)) + lo;
  }
  
  public static <T> void insertRandom(BinNode<T> tree, BinNode<T> ins) {
    while (!isLeaf(tree)) {
      if (tree.hasRight() && tree.hasLeft()) {
        if (Math.random() > 0.5) tree = tree.getRight();
        else tree = tree.getLeft();
      } else if (tree.hasRight()) {
        tree.setLeft(ins);
        return;
      } else {
        tree.setRight(ins);
        return;
      }
    }
    
    if (Math.random() > 0.5) {
      tree.setRight(ins);
    } else {
      tree.setLeft(ins);
    }
  }
  
  public static BinNode<Integer> genTree(int size, int lo, int hi) {
    BinNode<Integer> root = new BinNode<>(rand(lo, hi));
    for (int i = 0; i < size - 1; i++) {
      insertRandom(root, new BinNode<>(rand(lo, hi)));
    }
    return root;
  }
  
  public static <T> boolean contains(BinNode<T> tree, T val) {
    if (tree == null) return false;
    return Objects.equals(val, tree.getValue()) || contains(tree.getLeft(), val) || contains(tree.getRight(), val);
  }
}
