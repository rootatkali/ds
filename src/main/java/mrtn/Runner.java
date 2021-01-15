package mrtn;

import DS.Node;
import node.NodeUtils;

public class Runner {
  private String id;
  private int yearB;
  private Node<Item> lstItems;
  
  public Runner(String id, int yearB) {
    this.id = id;
    this.yearB = yearB;
  }
  
  public Runner(Runner r) {
    this.id = r.id;
    this.yearB = r.yearB;
    this.lstItems = copy(r.lstItems);
  }
  
  public String getId() {
    return id;
  }
  
  public int getYearB() {
    return yearB;
  }
  
  private Node<Item> copy(Node<Item> lst) {
    if (lst == null) return null;
    
    Node<Item> copy = new Node<>(new Item(lst.getValue()));
    
    Node<Item> cr = copy;
    while (lst.hasNext()) {
      lst = lst.getNext();
      cr.setNext(new Node<>(new Item(lst.getValue())));
      cr = cr.getNext();
    }
    
    return copy;
  }
  
  public Node<Item> getLstItems() {
    return copy(lstItems);
  }
  
  public Runner addItems(Item... items) {
    if (lstItems == null) {
      lstItems = new Node<>(new Item(items[0]));
    } else {
      NodeUtils.getLast(lstItems).setNext(new Node<>(new Item(items[0])));
    }
    
    for (int j = 1; j < items.length; j++) {
      Item i = items[j];
      NodeUtils.getLast(lstItems).setNext(new Node<>(new Item(i)));
    }
    
    return this;
  }
  
  public void setLstItems(Node<Item> lstItems) {
    this.lstItems = copy(lstItems);
  }
  
  @Override
  public String toString() {
    return "Runner{" +
        "id=\"" + id + '"' +
        ", yearB=" + yearB +
        ", lstItems=" + NodeUtils.stringify(lstItems) +
        '}';
  }
}
