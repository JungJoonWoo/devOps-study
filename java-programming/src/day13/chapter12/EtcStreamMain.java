package day13.chapter12;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EtcStreamMain {
  public static void main(String[] args) {

    IntStream.iterate(1, i -> i + 2).limit(10).forEach(System.out::println);

    new Random().ints(-100, 100).limit(10L).forEach(System.out::println);

    Stream.generate(Math::random).limit(10L).forEach(System.out::println);

    IntStream.range(1, 100).forEach(System.out::println);

    IntStream.rangeClosed(1, 100).forEach(System.out::println);
  }
}