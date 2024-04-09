package day8.chapter6;

public class Person {
  private final String residentNo;

  public Person(String residentNo) {
    this.residentNo = residentNo;
  }

  public String getResidentNo() {
    return residentNo;
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Person p) && (residentNo == p.getResidentNo());
  }
}