package day6.chapter5;

public class Ball {
  private int radius;
  private String color;

  protected Ball(int radius, String color) {
    this.radius = radius;
    this.color = color;
  }

  public void print() {
    System.out.println("radius = " + radius);
    System.out.println("color = " + color);
  }

  public int getRadius() {
    return radius;
  }

  public String getColor() {
    return color;
  }

}