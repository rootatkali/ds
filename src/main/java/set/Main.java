package set;

import DS.Queue;

public class Main {
  public static boolean isAInB(SetPoint4D a, SetPoint4D b) {
    boolean in = true;
    Queue<Point4D> qA = a.toQueue();

    while (!qA.isEmpty()) {
      in = in && b.contains(qA.head());
      qA.remove();
    }
    
    return in;
  }
  
  public static SetPoint4D intersection(SetPoint4D a, SetPoint4D b) {
    SetPoint4D ret = new SetPoint4D();
    Queue<Point4D> q = a.toQueue();
    
    while (!q.isEmpty()) {
      if (b.contains(q.head())) {
        ret.add(q.remove());
      } else {
        q.remove();
      }
    }
    
    return ret;
  }
  
  public static void main(String[] args) {
    // Define points
    Point4D origin = new Point4D(0, 0, 0, 0);
    Point4D unitX = new Point4D(1, 0, 0, 0);
    Point4D unitY = new Point4D(0, 1, 0, 0);
    Point4D unitZ = new Point4D(0, 0, 1, 0);
    Point4D unitT = new Point4D(0, 0, 0, 1);
    Point4D oneAll = new Point4D(1, 1, 1, 1);
    
    // Define set 1
    SetPoint4D set1 = new SetPoint4D();
    set1.add(origin);
    set1.add(origin); // false
    set1.add(unitX);
    set1.add(oneAll);
    set1.delete(origin);
    System.out.println(set1.toString());
    System.out.println();
    
    // Define set 2
    SetPoint4D set2 = new SetPoint4D();
    set2.add(unitX);
    set2.add(unitY);
    set2.add(unitZ);
    set2.add(unitT);
    set2.add(unitT); // false
    System.out.println(set2);
    System.out.println();
  
    // Test isAInB
    System.out.println(isAInB(set1, set2)); // false
  
    // Test intersection
    System.out.println(intersection(set1, set2));
  }
}
