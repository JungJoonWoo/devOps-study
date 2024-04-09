package day7.chapter6;

public class Cylinder extends Circle {
  int height;

  public Cylinder(int radius, String color, int height) {
    super(radius);
    this.color = color;
    this.height = height;
  }

  @Override
  public void findArea() {
    System.out.println(2 * Math.PI * Math.pow(radius, 2) + 2 * Math.PI * radius * height);
  }
}