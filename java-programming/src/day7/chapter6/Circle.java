package day7.chapter6;

public class Circle {
  int radius = 10;
  String color;

  public Circle(int radius) {
    this.radius = radius;
  }

  public void findRadius() {
    System.out.println("radius = " + radius);
  }
  public void findArea() {
    System.out.println(Math.pow(radius, 2) * Math.PI);

  }
}