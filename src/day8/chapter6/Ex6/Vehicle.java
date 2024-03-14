package day8.chapter6.Ex6;

public class Vehicle {
  private String color;
  private int speed;

  public Vehicle(String color, int speed) {
    this.color = color;
    this.speed = speed;
  }

  public String getColor() {
    return color;
  }

  public int getSpeed() {
    return speed;
  }

  void show() {
    System.out.println("color = " + color);
    System.out.println("speed = " + speed);
  }
}