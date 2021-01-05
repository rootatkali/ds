package node;

import DS.Node;

import java.util.Arrays;

import static node.NodeUtils.*;

public class Chars {
  public static Node<Integer> charToInt(Node<Character> lst) {
    if (lst == null) return null;
    return new Node<>((int) lst.getValue(), charToInt(lst.getNext()));
  }
  
  public static Node<Integer> chIntRev(Node<Character> lst) {
    Node<Integer> node = new Node<>((int) lst.getValue());
    
    if (!lst.hasNext()) return node;
    
    Node<Integer> next = chIntRev(lst.getNext());
    Node<Integer> crt = next;
    while (crt.hasNext()) crt = crt.getNext();
    crt.setNext(node);
    return next;
  }
  
  public static void main(String[] args) {
    Node<Character> cn = newFrom('H', 'e', 'l', 'l', 'o');
    System.out.println(stringify(charToInt(cn)));
    System.out.println(stringify(chIntRev(cn)));
  }
}
