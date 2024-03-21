package day13.chapter12;

import java.util.Random;
import java.util.stream.IntStream;

public class LazyMain {
  public static void main(String[] args) {
    IntStream.rangeClosed(1, 5)
        .filter(i -> {
          System.out.println("i = " + i);
          return i % 2 == 0;
        })
        .map(i -> (int) Math.pow(i, 2))
        .forEach(i -> System.out.println("map = " + i));

    new Random().ints(1, 100)
        .filter(i -> i % 2 == 0)
        .limit(5L)
        .forEach(System.out::println);
  }
}