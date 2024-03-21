package day13.chapter12;

import java.util.stream.Stream;

public class MapMain {
  public static void main(String[] args) {
    Stream.of("a1", "b1", "c1", "d1")
        .map(String::toUpperCase)
        .forEach(System.out::println);

    Stream.of("a1", "b2", "c3", "d4")
        .map(s -> (Integer.parseInt(s.substring(1))))
        .map(i -> (int)Math.pow(i, 2) * 10)
        .forEach(System.out::println);

  }
}