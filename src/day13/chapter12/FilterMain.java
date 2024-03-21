package day13.chapter12;

import java.util.stream.Stream;

public class FilterMain {
  public static void main(String[] args) {
    Stream.of("a1", "b2", "b1", "c1", "c2", "c4", "c5", "c6", "c7")
        .filter(x -> x.startsWith("c"))
        .skip(2L)
        .forEach(System.out::println);

    Nation.nations.stream()
        .filter(nation -> nation.getPopulation() > 100.0)
        .limit(2).forEach(System.out::println);

  }
}