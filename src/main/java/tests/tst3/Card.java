package tests.tst3;

import java.util.Objects;

public class Card {
  private int num;
  private String color;
  
  public Card(int num, String color) {
    this.num = num;
    this.color = color;
  }
  
  public Card(Card c) {
    this(c.num, c.color);
  }
  
  public int getNum() {
    return num;
  }
  
  public void setNum(int num) {
    this.num = num;
  }
  
  public String getColor() {
    return color;
  }
  
  public void setColor(String color) {
    this.color = color;
  }
  
  @Override
  public String toString() {
    return "Card{" +
        "num=" + num +
        ", color='" + color + '\'' +
        '}';
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Card card = (Card) o;
    return num == card.num && Objects.equals(color, card.color);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(num, color);
  }
}
