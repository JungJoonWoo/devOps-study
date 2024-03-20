package day12.chapter11;

import java.util.Arrays;
import java.util.List;

public class IteratorMain {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("다람쥐", "나비", "개구리");

    list.iterator().forEachRemaining(System.out::println);
  }
}