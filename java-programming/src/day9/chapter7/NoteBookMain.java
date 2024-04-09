package day9.chapter7;

public class NoteBookMain {
  public static void main(String[] args) {
    Controllable c1 = new NoteBook();
    ((NoteBook) c1).inMyBag();
    c1.turnOn();
    c1.turnOff();

  }

}