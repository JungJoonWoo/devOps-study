package day9.chapter7;

public interface Controllable {
  void turnOn();

  void turnOff();

  default void repair() {
    show("수리한다");
  }

  static void reset() {
    System.out.println("초기화 한다.");
  }

  private void show(String s) {
    System.out.println(s);
  }
}