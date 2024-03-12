package day4.chapter4;

import static java.lang.Math.pow;


public class Circle {

  private String color;

  private int radius;

  Circle() {
    this(1, "White");

  }

  Circle(int radius) {
    this(radius, "White");
  }

  Circle(String color) {
    this(1, color);
  }

  public Circle(int radius, String color) {
    this.color = color;
    if (radius > 0) {
      this.radius = radius;
    }
  }

  public int getRadius() {
    return radius;
  }

  public String getColor() {
    return color;
  }

  double findArea() {
    return pow(radius, 2) * 3.14;
  }

  void show() {
    System.out.printf("반지름: %d, 색깔: %s, 원의 넓이: %.2f\n", getRadius(), getColor(), findArea());
  }
}