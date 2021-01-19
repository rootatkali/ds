package mrtn;

import DS.Node;
import node.NodeUtils;

import java.util.Arrays;

public class Main {
  private static int consec(Runner r) {
    Node<Item> lst = r.getLstItems();
    if (lst == null) return 0;
    
    int max = 1;
    int crt = 1;
    int year = lst.getValue().getYear();
    lst = lst.getNext();
    while (lst != null) {
      if (lst.getValue().getYear() == year + 1) {
        crt++;
      } else if (lst.getValue().getYear() != year) {
        crt = 1;
      }
      if (crt > max) {
        max = crt;
      }
      year = lst.getValue().getYear();
      lst = lst.getNext();
    }
    
    return max;
  }
  
  public static int champions(MrtnRace m) {
    int cnt = 0;
    Node<Runner> r = m.getLstRunners();
    
    while (r != null) {
      if (consec(r.getValue()) >= 3) cnt++;
      r = r.getNext();
    }
    
    return cnt;
  }
  
  public static int championsStream(MrtnRace m) {
    return (int) NodeUtils.toStream(m.getLstRunners()).map(Main::consec).filter(i -> i >= 3).count();
  }
  
  public static void main(String[] args) {
    MrtnRace race = new MrtnRace("ISR", 2021);
    Runner r1 = new Runner("1", 2004)
        .addItems(
            new Item(2014, 100),
            new Item(2016, 97),
            new Item(2018, 102),
            new Item(2019, 85),
            new Item(2020, 93)
        );
    Runner r2 = new Runner("2", 2003)
        .addItems(
            new Item(2014, 103),
            new Item(2015, 96),
            new Item(2017, 102),
            new Item(2018, 84),
            new Item(2020, 93)
        );
    Runner r3 = new Runner("3", 2002);
    r3.setLstItems(r2.getLstItems().getNext()); // Same as r2 (copied items), but from second year
    Runner r4 = new Runner("4", 2004)
        .addItems(
            new Item(2020, 76)
        );
    Runner r5 = new Runner("5", 2000);
  
    Runner[] runners = {r1, r2, r3, r4, r5};
    
    Arrays.stream(runners).forEach(race::addRunner); // add all to race
    
    Arrays.stream(runners).map(Runner::getId).forEach(id -> race.addScoreToRunner(id, (int) (Math.random() * 10) + 95));
    System.out.println(race);
    System.out.println("# of champions: " + champions(race));
  }
}
