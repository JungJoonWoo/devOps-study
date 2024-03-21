package day13.chapter12;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingMain {
  public static void main(String[] args) {
    Stream<Nation> s1 = Nation.nations.stream().limit(4);

    Map<Nation.Type, List<Nation>> collect = s1.collect(Collectors.groupingBy(Nation::getType));
    System.out.println(collect);

    Stream<Nation> s2 = Nation.nations.stream().limit(4);
    System.out.println(s2
        .collect(
            Collectors.groupingBy(Nation::getType, Collectors.counting())));

    Stream<Nation> s3 = Nation.nations.stream().limit(4);
    System.out.println(s3.collect(Collectors
        .groupingBy(Nation::getType,
            Collectors.mapping(Nation::getName, Collectors.joining("#")))));
  }
}