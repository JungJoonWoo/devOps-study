package day9.chapter7;

public class NoteBook extends Computer implements Portable {

  @Override
  public void inMyBag() {
    System.out.println("NoteBook.inMyBag");
  }

  @Override
  public void turnOn() {
    System.out.println("NoteBook.turnOn");
  }

  @Override
  public void turnOff() {
    System.out.println("NoteBook.turnOff");
  }
}