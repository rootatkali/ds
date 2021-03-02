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
  
  public static <T> boolean containsNode(BinNode<T> tree, BinNode<T> node) {
    if (tree == null) return false;
    return tree == node || containsNode(tree.getLeft(), node) || containsNode(tree.getRight(), node);
  }
  
  public static <T> BinNode<T> findNodeByVal(BinNode<T> tree, T val) {
    if (val == null) return null;
    if (tree == null) return null;
    if (tree.getValue() == val) return tree;
    if (findNodeByVal(tree.getLeft(), val) != null) return findNodeByVal(tree.getLeft(), val);
    if (findNodeByVal(tree.getRight(), val) != null) return findNodeByVal(tree.getRight(), val);
    return null;
  }
  
  public static <T> int cntLvlR(BinNode<T> tree) {
    if (tree == null) return 0;
    return 1 + Math.max(cntLvlR(tree.getLeft()), cntLvlR(tree.getRight()));
  }
  
  private static <T> boolean isBig(BinNode<T> tree) {
    return tree != null && tree.hasLeft() && tree.hasRight();
  }
  
  public static <T> boolean twoOrZeroSons(BinNode<T> tree) {
    if (tree == null) return false;
    if (isLeaf(tree)) return true;
    if (!isBig(tree)) return false;
    return twoOrZeroSons(tree.getLeft()) && twoOrZeroSons(tree.getRight());
  }
  
  public static <T> String valsAtLevel(BinNode<T> tree, int level) {
    if (tree == null) return "";
    if (level == 1) return String.valueOf(tree.getValue());
    return (valsAtLevel(tree.getLeft(), level - 1) + " " + valsAtLevel(tree.getRight(), level - 1))
        .replaceAll("\\s+", " ").trim();
  }
  
  public static <T> boolean containsAll(BinNode<T> t1, BinNode<T> t2) {
    if (t1 == null) return false;
    if (isLeaf(t2)) return contains(t1, t2.getValue());
    return contains(t1, t2.getValue()) &&
        (!t2.hasLeft() || containsAll(t1, t2.getLeft())) &&
        (!t2.hasRight() || containsAll(t1, t2.getRight()));
  }
  
  public static <T> boolean equalsByVal(BinNode<T> t1, BinNode<T> t2) {
    return containsAll(t1, t2) && containsAll(t2, t1);
  }
}
