package special;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Pole p = new Pole();
    Arrays.stream(new Ring[]{
        new Ring(),
        new Ring(),
        new Ring("S", 1),
        new Ring(),
        new Ring("S", 2),
        new Ring("S", 4),
        new Ring()
    }).forEach(p::add);
    p.sort();
    System.out.println(p);
  }
}
