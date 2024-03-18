package day10.chapter8;

import java.util.Arrays;

public class ArraysMain {
  public static void main(String[] args) {
    char[] a1 = {'j', 'a', 'v', 'a'};
    System.out.println(a1);
    char[] a2 = Arrays.copyOf(a1, a1.length);
    System.out.println(a2);

    String[] s1 = {"케이크", "사과", "바나나", "도넛"};
    System.out.println(Arrays.binarySearch(s1,"사과"));

  }
}