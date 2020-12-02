package stack;

import DS.Stack;

import obj.Point;

public class StackTest {
  public static void main(String[] args) {
    Stack<Integer> s1 = StackUtils.newFrom(1, 2, 3, 4, 5);
//    System.out.println(s1);
//    System.out.println(StackUtils.copy(s1));
//    System.out.println(IntUtils.occInStack(s1, 2));

//    System.out.println(IntUtils.rem1FromStk(s1, 3));
//    System.out.println(s1);
    
    
    if (IntUtils.sum(s1) != Recurse.sum(s1)) throw new AssertionError();
    
    Stack<Point> s2 = StackUtils.newFrom(
        new Point(0, 0),
        new Point(1, 1),
        new Point(2, 3)
    );
  
    System.out.println(s2);
    Point p;
    while (!s2.isEmpty()) {
      if ((p = s2.pop()).equals(new Point(2, 3))) {
        System.out.println(p);
        StackUtils.clear(s2);
      }
    }
  }
}
