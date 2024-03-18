package day10.chapter8.Ex2;

public class Person {
  private String name;
  private String regidentNo;

  public String getName() {
    return name;
  }

  public String getRegidentNo() {
    return regidentNo;
  }

  public Person(String name, String regidentNo) {
    this.name = name;
    this.regidentNo = regidentNo;
  }
}