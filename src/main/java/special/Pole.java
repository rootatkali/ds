package special;

import DS.Stack;

public class Pole {
  private Stack<Ring> stack;
  
  public Pole() {
    stack = new Stack<>();
  }
  
  public void add(Ring r) {
    stack.push(new Ring(r.getSize(), r.getColor()));
  }
  
  public Ring remove() {
    Ring r = stack.pop();
    return new Ring(r.getSize(), r.getColor());
  }
  
  public boolean isEmpty() {
    return stack.isEmpty();
  }
  
  public void sort() {
    Pole l = new Pole(), s = new Pole();
    
    while (!isEmpty()) {
      Ring r = remove();
      
      if (r.getSize().equals("L")) l.add(r);
      else s.add(r);
    }
    
    while (!l.isEmpty()) add(l.remove());
    while (!s.isEmpty()) add(s.remove());
  }
  
  @Override
  public String toString() {
    return "Pole{" +
        "stack=" + stack +
        '}';
  }
}
