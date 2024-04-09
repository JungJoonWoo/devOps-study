package day3.chapter4;

public class Bird extends Animal {
  @Override
  void eat() {
    System.out.println("새가 먹는다");
  }

  @Override
  void move() {
    System.out.println("새가 난다");
  }
}