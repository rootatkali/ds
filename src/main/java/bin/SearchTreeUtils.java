package bin;

import DS.BinNode;

import java.util.stream.IntStream;

public class SearchTreeUtils {
  public static <T extends Comparable<T>> void insert(BinNode<T> tree, T val) {
    if (tree == null) return;
    if (val.compareTo(tree.getValue()) < 0) {
      if (!tree.hasLeft()) {
        tree.setLeft(new BinNode<>(val));
      } else {
        insert(tree.getLeft(), val);
      }
    } else {
      if (!tree.hasRight()) {
        tree.setRight(new BinNode<>(val));
      } else {
        insert(tree.getRight(), val);
      }
    }
  }
  
  public static <T extends Comparable<T>> BinNode<T> genSearchTree(T... vals) {
    BinNode<T> root = new BinNode<>(vals[0]);
    IntStream.range(1, vals.length).forEach(i -> insert(root, vals[i]));
    return root;
  }
  
  public static <T extends Comparable<T>> boolean lookup(BinNode<T> tree, T val) {
    if (val.compareTo(tree.getValue()) == 0) return true;
    if (TreeUtils.isLeaf(tree)) return false;
    return lookup(val.compareTo(tree.getValue()) > 0 ? tree.getRight() : tree.getLeft(), val);
  }
}
