package day9.chapter7.Ex8;

public abstract class Controller {
  private boolean power;

  public boolean isPower() {
    return power;
  }

  public Controller(boolean power) {
    this.power = power;
  }

  abstract void show();
}