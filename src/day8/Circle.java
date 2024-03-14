package day8;

public class Circle {
  private final int radius;

  public Circle(int radius) {
    this.radius = radius;
  }

  public int getRadius() {
    return radius;
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Circle c) && (c.radius == radius);
  }
}