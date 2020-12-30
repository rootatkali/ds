package mrtn;

import DS.Node;

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
  
  public static void main(String[] args) {
    MrtnRace race = new MrtnRace("ISR", 2020);
    Runner r = new Runner("1", 2004);
    Runner r2 = new Runner("2", 2003);
    race.addRunner(r);
    race.addRunner(r2);
    race.addScoreToRunner("1", 10);
    System.out.println(race);
  
    MrtnRace race2 = new MrtnRace("RUS", 2021);
    race2.addRunner(r);
    race2.addScoreToRunner("1", 11);
    System.out.println(race2);
    
    MrtnRace race3 = new MrtnRace("GER", 2019);
    race3.addRunner(r);
    race3.addScoreToRunner("1", 9);
  
    MrtnRace race4 = new MrtnRace("USA", 2019);
    race4.addRunner(r);
    race4.addScoreToRunner("1", 9);
  
    System.out.println(race4);
    System.out.println(champions(race));
  }
}
