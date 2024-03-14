package day7.chapter6;

public class Student extends Person {
  public int number = 7;
  public String name = "student";

  @Override
  public void work() {
    System.out.println("공부함");
  }

}