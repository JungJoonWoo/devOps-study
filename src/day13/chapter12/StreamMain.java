package day13.chapter12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StreamMain {
  public static void main(String[] args) {
    Random r = new Random();
    List<Integer> randomList = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      randomList.add(r.nextInt(30));
    }
    List<Integer> gt10 = new ArrayList<>();
    for (Integer i : randomList) {
      if (i > 10) {
        gt10.add(i);
      }
    }
    Collections.sort(gt10);
    System.out.println(gt10);

    randomList.stream().filter(i -> i > 10).sorted().forEach(System.out::println);
    System.out.println();

  }
}