package day4.exercise;

public class Circle {
  static int numberOfCircles;
  int radius;
  String color = "";

  public Circle(int radius, String color) {
    this.radius = radius;
    this.color = color;
    System.out.println("radius = " + radius);
    System.out.println("color = " + color);
    System.out.println("numberOfCircle = " + ++numberOfCircles);
  }
}