package day9.chapter7.Ex6;

import java.util.Arrays;
import java.util.Comparator;

public class PersonMain {
  public static void main(String[] args) {
    Person[] people = {new Person("박지성", 10, 175, 68),
        new Person("홍길동", 32, 170, 75),
        new Person("손흥민", 20, 180, 70)
    };

    Arrays.stream(people).forEach(System.out::println);

    System.out.println();

    Arrays.stream(Arrays.stream(people)
        .sorted(Comparator.comparingInt(Person::getAge).reversed())
        .toArray(Person[]::new)).forEach(System.out::println);
  }

}