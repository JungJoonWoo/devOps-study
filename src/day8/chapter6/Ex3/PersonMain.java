package day8.chapter6.Ex3;

import day8.chapter6.Ex3.ForeignStudent;

import java.util.Arrays;

public class PersonMain {

  public static void main(String[] args) {
  Person[] people = {
      new Person("길동이", 22), new Student("황진이", 23, 100),
      new ForeignStudent("Amy", 30, 200, "U.S.A")};

    Arrays.stream(people).forEach((p)->{
      System.out.print("사람[");
      p.show();
      System.out.print("]\n");

    });
  }

}