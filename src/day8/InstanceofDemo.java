package day8;

import day7.chapter6.Employee;
import day7.chapter6.Freelancer;
import day7.chapter6.Person;
import day7.chapter6.Student;

public class InstanceofDemo {
  public static void main(String[] args) {
    Person[] people = new Person[3];
    people[0] = new Freelancer();
    people[1] = new Student();
    people[2] = new Employee();

    for (Person person : people) {
      if (person instanceof Freelancer f) {
        System.out.println(f.name);
        System.out.println(f.number);
      } else if (person instanceof Student s) {
        System.out.println(s.name);
        System.out.println(s.number);
      } else if (person instanceof Employee e) {
        System.out.println(e.name);
        System.out.println(e.number);
      }
      person.work();
    }
  }
}