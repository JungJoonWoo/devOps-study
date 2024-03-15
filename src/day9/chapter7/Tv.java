package day9.chapter7;

public class Tv implements Controllable {

  @Override
  public void turnOn() {
    System.out.println("Tv.turnOn");
  }

  @Override
  public void turnOff() {
    System.out.println("Tv.turnOff");
  }

}