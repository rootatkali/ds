package special;

public class Ring {
  private String size;
  private int color;
  
  public Ring(String size, int color) {
    this.size = size;
    this.color = color;
  }
  
  public Ring() {
    this("L", 0);
  }
  
  public String getSize() {
    return size;
  }
  
  public int getColor() {
    return color;
  }
  
  @Override
  public String toString() {
    return "Ring{" +
        "size='" + size + '\'' +
        ", color=" + color +
        '}';
  }
}
