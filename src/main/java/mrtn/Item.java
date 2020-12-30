package mrtn;

import java.util.Objects;

public class Item {
  private final int year;
  private final int score;
  
  public Item(int year, int score) {
    this.year = year;
    this.score = score;
  }
  
  public Item(Item i) {
    if (i == null) {
      this.year = -1;
      this.score = -1;
    } else {
      this.year = i.year;
      this.score = i.score;
    }
  }
  
  public int getYear() {
    return year;
  }
  
  public int getScore() {
    return score;
  }
  
  @Override
  public String toString() {
    return "Item{" +
        "year=" + year +
        ", score=" + score +
        '}';
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Item item = (Item) o;
    return year == item.year && score == item.score;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(year, score);
  }
}
