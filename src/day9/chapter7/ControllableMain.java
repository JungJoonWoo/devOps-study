package day9.chapter7;

public class ControllableMain {
  public static void main(String[] args) {
    Controllable c1 = new Computer();
    c1.turnOn();
    c1.turnOff();
    c1.repair();
    Controllable.reset();

    Controllable c2 = new Tv();
    c2.turnOn();
    c2.turnOff();
    c2.repair();
    Controllable.reset();

  }
}