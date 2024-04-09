package day10.chapter8.Ex5;

public class DiceMain {
  public static void main(String[] args) {
    Dice d = new Dice();
    for (int i = 0; i < 100; i++) {
      System.out.println((d.roll()));
    }
  }
}