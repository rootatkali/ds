package queue;

public class SetTest {
  public static void main(String[] args) {
    Set s1 = Set.newFrom(1, 2, 3, 4, 5);
    Set s2 = Set.newFrom(2, 4, 6, 8, 10);
    System.out.println(s1.intersect(s2));
    System.out.println(s2.intersect(s1));
    System.out.println();
    System.out.println(s1.union(s2));
    System.out.println(s2.union(s1));
  
    System.out.println("\n\n");
    
    Set s3 = Set.newFrom(1, 2, 3);
    s3.add(3);
    s3.add(4);
    System.out.println(s3);
  }
}
