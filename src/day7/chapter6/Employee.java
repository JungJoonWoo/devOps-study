package day7.chapter6;

public class Employee extends Person {
  public int number = 4;
  public String name = "Employee";


  @Override
  public void work() {
    System.out.println("일함");
  }
}