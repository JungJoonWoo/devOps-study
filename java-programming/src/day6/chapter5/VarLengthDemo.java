package day6.chapter5;

import java.util.Arrays;

public class VarLengthDemo {
  public static void main(String[] args) {
//    printNum(1,2,3,4,5,6,67,7,78,6,435,35,345,12412,35,324532);
    printSum(1, 2, 3, 4, 5, 6, 67, 7, 78, 6, 435, 35, 345, 12412, 35, 324532);
  }

  static void printNum(int... nums) {
    Arrays.stream(nums).forEach(System.out::println);
  }

  static void printSum(int... nums) {
    System.out.println((Arrays.stream(nums).sum()));
  }
}