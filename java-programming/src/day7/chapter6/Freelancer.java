package day7.chapter6;

public class Freelancer extends Person {
  public int number = 10;
  public String name = "Freelancer";
  @Override
  public void work() {
    System.out.println("자유롭게 일함");
  }
}