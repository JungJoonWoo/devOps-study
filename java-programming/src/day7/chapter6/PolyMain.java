package day7.chapter6;

public class PolyMain {
  public static void main(String[] args) {

    Person s = new Student();
    Person e = new Employee();
    ((Student) s).work();
    Student s2 = new Student();
    Person[] p2 = {s2 , new Employee(), new Person()};

  }
}