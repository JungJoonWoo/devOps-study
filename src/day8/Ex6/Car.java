package day8.Ex6;

public class Car extends Vehicle {
  private int displacement;
  private int gears;

  public Car(String color, int speed, int displacement, int gears) {
    super(color, speed);
    this.displacement = displacement;
    this.gears = gears;
  }

  public int getDisplacement() {
    return displacement;
  }

  public int getGears() {
    return gears;
  }

  @Override
  void show() {
    System.out.println("color = " + getColor());
    System.out.println("speed = " + getSpeed());
    System.out.println("displacement = " + displacement);
    System.out.println("gears = " + gears);
  }
}