package day9.chapter7.Ex4;

public class Triangle implements Comparable {
  private int height;
  private int width;

  public Triangle(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  private double getArea(){
    return (double) getHeight() * getWidth() / 2;
  }

  @Override
  public int compareTo(Object o) {
    if (o instanceof Triangle t) {
      if (getArea() > t.getArea()) {
        return 1;
      } else if (getArea() < t.getArea()) {
        return -1;
      } else if (getArea() == t.getArea()) {
        return 0;
      }
    }
    return -999;
  }

  @Override
  public String toString() {
    return String.format("삼각형 [width = %d, height = %d, 넓이 = %d] 이 더 큽니다.", getWidth(), getHeight(), (int) getArea());
  }
}