package recursion;

public class Bridge {
  public static int bridgeXY(int x, int y) { // FIXME This is dumb
    if (x > y) throw new IllegalArgumentException("x > y");
    if (x == y) return 0;
    if (((2 * x) <= y) && ((2 * x) > x)) return 1 + bridgeXY(2 * x, y);
    return 1 + bridgeXY(x + 1, y);
  }
  
  public static void main(String[] args) {
    System.out.println(bridgeXY(2, 11));
    System.out.println(bridgeXY(0, 11));
  }
}
