package day8.Ex3;

public class Person {
  private int age;
  private String name;

  public Person(String name, int age) {
    this.age = age;
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public void show() {
    System.out.printf("이름: %s, 나이: %d", getName(), getAge());
  }
}