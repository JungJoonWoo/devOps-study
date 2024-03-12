package day2.chapter3;

import java.util.Scanner;

public class SimpleDemo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //method1(sc);
    method2(sc);
  }

  private static void method2(Scanner sc) {
    int n = sc.nextInt();
    char c;
    if (n >= 90 && n <= 100) {
      c = 'A';
    } else if (n >= 80) {
      c = 'B';
    } else {
      c = 'C';
    }
    System.out.println(c);

  }

  private static void method1(Scanner sc) {
    int n = sc.nextInt();

    if (n % 2 == 0)
      System.out.println("짝수입니다");
    else
      System.out.println("홀수입니다.");
  }
}