package day9.chapter7;

public class Computer implements Controllable{
  @Override
  public void turnOn() {
    System.out.println("Computer.turnOn");
  }

  @Override
  public void turnOff() {
    System.out.println("Computer.turnOff");
  }
}