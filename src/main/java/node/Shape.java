package node;

import DS.Node;
import set.Point4D;

public class Shape {
  private static int rand(int lo, int hi) {
    return (int) (Math.random() * (hi - lo + 1)) + lo;
  }
  
  private static Point4D gen(int lo, int hi) {
    return new Point4D(rand(lo, hi), rand(lo, hi), rand(lo, hi), rand(lo, hi));
  }
  
  public static Node<Point4D> shape(int size, int lo, int hi) {
    if (size <= 0) return null;
    
    Node<Point4D> head = new Node<>(gen(lo, hi));
    Node<Point4D> last = head;
    
    for (int i = 1; i < size; i++) {
      last.setNext(new Node<>(gen(lo, hi)));
      last = last.getNext();
    }
    
    return head;
  }
  
  public static void main(String[] args) {
    System.out.println(NodeUtils.stringify(shape(4, -5, 5)));
  }
}
