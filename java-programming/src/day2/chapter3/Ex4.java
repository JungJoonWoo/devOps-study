package day2.chapter3;

import java.util.Scanner;

public class Ex4 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    double n = sc.nextDouble();
    double res = 50_000 / n;
    if (Double.isInfinite(res) || Double.isNaN(res)) {
      System.out.println("무한대 값 입니다.");
    }
    else {
      System.out.println("res = " + res + 15_000);
    }

  }
}