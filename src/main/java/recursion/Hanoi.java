package recursion;

public class Hanoi {
  private static void announce(int n, char from, char to) {
    System.out.printf("Move disk %d from %s to %s\n", n, from, to);
  }
  
  public static void hanoi(int n, char from, char to, char via) {
    if (n == 1) {
      announce(1, from, to);
      return;
    }
    hanoi(n - 1, from, via, to);
    announce(n, from, to);
    hanoi(n - 1, via, to, from);
  }
  
  public static void main(String[] args) {
  
  }
}
