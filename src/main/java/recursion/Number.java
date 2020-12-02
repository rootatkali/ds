package recursion;

public class Number {
  public static void printNum(int n) {
    if (n > 1) printNum(n - 1);
    System.out.println(n);
  }
  
  public static String revNum(int n) {
    int dig = n % 10;
    if (n == dig) return Integer.toString(n);
    return String.format("%d%s", dig, revNum(n / 10));
  }
  
  public static String revRevNum(int n) {
    int dig = n % 10;
    if (n == dig) return Integer.toString(n);
    return String.format("%s%d", revNum(n / 10), dig);
  }
  
  public static String revRevRevRevNum(int n) {
    if (n == -1) return "";
    return revRevRevRevNum(-1) + n;
  }
  
  public static void main(String[] args) {
    printNum(10);
    System.out.println(revNum(1234));
  }
}
