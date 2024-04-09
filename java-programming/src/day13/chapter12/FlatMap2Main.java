package day13.chapter12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMap2Main {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("안녕, 자바");
    list.add("잘 가, C++!");

    list.stream().flatMap(s -> Arrays.stream(s.split(" "))).forEach(System.out::println);

    List<String> l1 = List.of("Good Morning");
    List<String> l2 = List.of("hello world", "welcome, stream!");

    Stream.of(list, l1, l2).flatMap(l -> {
      if (list.size() > 1)
        return list.stream();
      else
        return Stream.empty();
    }).forEach(Util::print);
  }
}