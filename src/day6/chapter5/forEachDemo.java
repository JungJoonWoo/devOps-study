package day6.chapter5;

import java.util.Arrays;

public class forEachDemo {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int even = Arrays.stream(arr).filter(s -> (s % 2 == 0)).sum();
    int odd = Arrays.stream(arr).filter(s -> (s % 2 == 1)).sum();
    System.out.println("odd = " + odd);
    System.out.println("even = " + even);
    Arrays.stream(args).forEach(System.out::println);
  }
}