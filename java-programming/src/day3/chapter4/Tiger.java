package day3.chapter4;

public class Tiger extends Animal {
//  int legs = 4;
  @Override
  void eat() {
    System.out.println("호랑이가 먹는다");
  }

  @Override
  void move() {
    System.out.println("호랑이가 움직인다");
  }

}