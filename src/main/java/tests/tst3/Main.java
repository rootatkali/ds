package tests.tst3;

import DS.Node;
import node.NodeUtils;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {
  private static <T> void swap(Node<T> a, Node<T> b) {
    // Swap values of two Nodes
    T tmp = a.getValue();
    a.setValue(b.getValue());
    b.setValue(tmp);
  }
  
  private static Node<Card> findMin(Node<Card> fst) {
    // Find card with min value in list
    Node<Card> min = fst;
    
    while (fst != null) {
      if (fst.getValue().getNum() < min.getValue().getNum()) { // min num in card
        min = fst;
      }
      fst = fst.getNext();
    }
    
    return min;
  }
  
  public static void group(Node<Card> fst) {
    // Insertion sort by card values
    while (fst.hasNext()) {
      swap(fst, findMin(fst));
      fst = fst.getNext();
    }
  }
  
  private static void printNums(Node<Card> lst) {
    while (lst != null) {
      System.out.print(lst.getValue().getNum() + " ");
      lst = lst.getNext();
    }
    System.out.println();
  }
  
  public static int cnt3(Node<Card> lst) {
    int add = 0;
    if (lst.getValue().getNum() == 3) add = 1;
    if (lst.hasNext()) return add + cnt3(lst.getNext());
    return add;
  }
  
  public static void main(String[] args) {
    Card[] cards = new Card[20];
    IntStream.range(0, cards.length).forEach(i -> cards[i] = new Card(new Random().nextInt(9) + 1, ""));
    Node<Card> lst = NodeUtils.newFrom(cards);
    printNums(lst);
    group(lst);
    printNums(lst);
    System.out.println(cnt3(lst));
  }
}
