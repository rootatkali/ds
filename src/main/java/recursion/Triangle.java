package recursion;

public class Triangle {
  public static void pTriangle(int n) {
    for (int i = 0; i < n; i++) {
      System.out.print('*');
    }
    System.out.println();
    if (n >= 1) pTriangle(n - 1);
  }
  
  public static void pTriangleRev(int n) {
    if (n >= 1) pTriangleRev(n - 1);
    for (int i = 0; i < n; i++) {
      System.out.print('*');
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    pTriangle(10);
    System.out.println();
    pTriangleRev(10);
  }
}
