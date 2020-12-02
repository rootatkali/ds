package set;

import java.util.Objects;

public class Point4D {
  private int x;
  private int y;
  private int z;
  private int t;
  
  public Point4D(int x, int y, int z, int t) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.t = t;
  }
  
  public Point4D(Point4D p) {
    this.x = p.x;
    this.y = p.y;
    this.z = p.z;
    this.t = p.t;
  }
  
  public int getX() {
    return x;
  }
  
  public void setX(int x) {
    this.x = x;
  }
  
  public int getY() {
    return y;
  }
  
  public void setY(int y) {
    this.y = y;
  }
  
  public int getZ() {
    return z;
  }
  
  public void setZ(int z) {
    this.z = z;
  }
  
  public int getT() {
    return t;
  }
  
  public void setT(int t) {
    this.t = t;
  }
  
  @Override
  public String toString() {
    return "Point4D{" +
        "x=" + x +
        ", y=" + y +
        ", z=" + z +
        ", t=" + t +
        '}';
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Point4D point4D = (Point4D) o;
    return x == point4D.x &&
        y == point4D.y &&
        z == point4D.z &&
        t == point4D.t;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(x, y, z, t);
  }
}
