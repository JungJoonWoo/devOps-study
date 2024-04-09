package day13.chapter12;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitionMain {
  public static void main(String[] args) {

    Stream<Nation> s = Nation.nations.stream();

    System.out.println(s.collect(Collectors.partitioningBy(n -> n.getPopulation() > 50, Collectors.counting())));

    s = Nation.nations.stream();

    System.out.println(s.collect(Collectors.partitioningBy(n -> n.getPopulation() > 50)));

  }
}