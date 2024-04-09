package day10.chapter8.Ex3;

public class Student {
  private String name;

  public Student(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "학생[" +
        name+
        ']';
  }
}