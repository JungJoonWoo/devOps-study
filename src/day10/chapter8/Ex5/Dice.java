package day10.chapter8.Ex5;

import java.util.Random;

public class Dice {

  public int roll() {
    Random r = new Random();
    return r.nextInt(1, 7);
  }
}