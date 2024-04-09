package day11.chapter10;

import java.util.Arrays;
import java.util.List;

public class LambdaMain {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 3, 5, 5, 2133, 123, 556324524, 1233123, 123432, 6546, 213, 1, 435665);

    list.sort((s1, s2) -> s2 - s1);
    System.out.println(list);

    List<String> list1 = Arrays.asList("aaa", "fdsf", "dfwaf", "daskjd", "adasdeoirk");

    long count = list1.stream().filter(l -> l.contains("a")).count();
    System.out.println("count = " + count);

    list1.sort((o1, o2) -> {
      if (o1.length() == o2.length())
        return o1.compareTo(o2);
      else
        return o1.length() - o2.length();
    });

    System.out.println(list1);
  }
}