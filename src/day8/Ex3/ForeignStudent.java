package day8.Ex3;

public class ForeignStudent extends Student {
  private String country;

  public ForeignStudent(String name,int age, int studentId, String country) {
    super(name, age, studentId);
    this.country = country;
  }

  public String getCountry() {
    return country;
  }

  @Override
  public void show() {
    System.out.printf("이름: %s, 나이: %d, 학번: %d, 국적: %s", getName(), getAge(), getStudentId(), getCountry());
  }
}