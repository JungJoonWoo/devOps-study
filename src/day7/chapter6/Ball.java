package day7.chapter6;

public class Ball extends Circle {

  Ball(int radius, String color) {
    super(radius);
    this.color = color;
  }

  public void findColor() {
    System.out.println("color = " + color);
  }

  @Override
  public void findArea() {
    System.out.println(4 * Math.PI * Math.pow(radius, 2));
  }
}