package day10.chapter8.Ex2;

import java.util.Arrays;

public class PersonMain {
  public static void main(String[] args) {
    Person[] people = {new Person("1111", "홍길동"), new Person("1111", "손흥민"), new Person("1111", "홍길동")};

    boolean b = Arrays.stream(people).allMatch((person -> {
      return person.getName().equals(people[0].getName()) && person.getRegidentNo().equals(people[0].getRegidentNo());
    }));
    if (b) {
      System.out.println("같음");
    } else {
      System.out.println("다름");
    }
  }
}