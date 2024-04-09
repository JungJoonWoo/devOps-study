package day12.chapter11.Ex2;

import java.util.HashSet;
import java.util.Set;

public class PersonMain {
  public static void main(String[] args) {
    Set<Person> set = new HashSet<>();
    set.add(new Person("김열공", 20));
    set.add(new Person("최고봉", 56));
    set.add(new Person("우등생", 16));
    set.add(new Person("나자바", 35));
    set.add(new Person("나자바", 40));

    set.forEach(System.out::println);
    System.out.println(set);
  }
}

class Person {
  private String name;
  private int age;

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Person p) {
      return getName().equals(p.getName());
    }
    return false;
  }

  @Override
  public String toString() {
    return getName() + ": " + getAge();
  }
}