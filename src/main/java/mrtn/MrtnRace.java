package mrtn;

import DS.Node;
import node.NodeUtils;

public class MrtnRace {
  private String country;
  private int year;
  private Node<Runner> lstRunners;
  
  public MrtnRace(String country, int year) {
    this.country = country;
    this.year = year;
  }
  
  private Node<Runner> copy(Node<Runner> lst) {
    if (lst == null) return null;
    
    Node<Runner> copy = new Node<>(new Runner(lst.getValue()));
    Node<Runner> crt = copy;
    while (lst.hasNext()) {
      lst = lst.getNext();
      crt.setNext(new Node<>(new Runner(lst.getValue())));
      crt = crt.getNext();
    }
    return copy;
  }
  
  public String getCountry() {
    return country;
  }
  
  public int getYear() {
    return year;
  }
  
  public Node<Runner> getLstRunners() {
    return copy(lstRunners);
  }
  
  public void addRunner(Runner r) {
    if (lstRunners == null) {
      lstRunners = new Node<>(r);
      return;
    }
    
    Node<Runner> crt = lstRunners;
    while (crt.hasNext()) crt = crt.getNext();
    crt.setNext(new Node<>(r));
  }
  
  private Runner getRunner(Node<Runner> lst, String id) {
    while (lst != null) {
      if (lst.getValue().getId().equals(id)) return lst.getValue();
      lst = lst.getNext();
    }
    return null;
  }
  
  public void addScoreToRunner(String id, int score) {
    Runner r = getRunner(lstRunners, id);
    if (r == null) return; // Runner not found / List empty
    
    Node<Item> lst = r.getLstItems();
    if (lst == null) {
      lst = new Node<>(new Item(year, score));
    } else {
      boolean edit = false;
      Node<Item> crt = lst;
      
      if (crt.getValue().getYear() > year) {
        lst = new Node<>(new Item(year, score), lst);
        edit = true;
      }
      
      while (!edit && crt.hasNext()) {
        if (crt.getNext().getValue().getYear() > year) {
          Node<Item> ins = new Node<>(new Item(year, score), crt.getNext());
          crt.setNext(ins);
          edit = true;
        }
        
        crt = crt.getNext();
      }
      
      if (!edit) {
        crt.setNext(new Node<>(new Item(year, score)));
      }
    }
    
    r.setLstItems(lst);
  }
  
  @Override
  public String toString() {
    return "MrtnRace{" +
        "country='" + country + '\'' +
        ", year=" + year +
        ", lstRunners=" + NodeUtils.stringify(lstRunners) +
        '}';
  }
}
