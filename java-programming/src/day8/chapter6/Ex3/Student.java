package day8.chapter6.Ex3;

public class Student extends Person{
  private int studentId;

  public Student(String name, int age, int studentId) {
    super(name, age);
    this.studentId = studentId;
  }

  public int getStudentId() {
    return studentId;
  }

  @Override
  public void show() {
    System.out.printf("이름: %s, 나이: %d, 학번: %d", getName(), getAge(), getStudentId());
  }
}