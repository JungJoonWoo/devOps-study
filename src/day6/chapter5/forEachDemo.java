package day6.chapter5;

import java.util.Arrays;

public class forEachDemo {
  public static void main(String[] args) {
    //배열 초기화
    int[] arr = {1, 2, 3, 4, 5};

    //홀, 짝 판별
    int even = Arrays.stream(arr).filter(s -> (s % 2 == 0)).sum();
    int odd = Arrays.stream(arr).filter(s -> (s % 2 == 1)).sum();

    System.out.println("odd = " + odd);
    System.out.println("even = " + even);

    //args 출력
    Arrays.stream(args).forEach(System.out::println);
  }
}