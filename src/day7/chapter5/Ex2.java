package day7.chapter5;

import java.util.Arrays;

public class Ex2 {
  public static void main(String[] args) {

    System.out.println(sum(1));
    System.out.println(sum(1, 2));
    System.out.println(sum(1, 2, 3));
    System.out.println(sum(1, 2, 3, 4));
    System.out.println(sum(1, 2, 3, 4, 5));
    System.out.println(sum(1, 2, 3, 4, 5, 6));
    System.out.println(sum(1, 2, 3, 4, 5, 6, 7));
  }

  static int sum(int... nums) {
    return (Arrays.stream(nums).sum());
  }
}