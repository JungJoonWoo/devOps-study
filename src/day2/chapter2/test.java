package day2.chapter2;

import java.util.Scanner;

public class test {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    problem1(sc);
  }

  private static void problem1(Scanner sc) {

    String s = sc.nextLine();
    System.out.println("당신이 입력한 내용은 " + s + " 입니다.");

    double result = Double.parseDouble(s) + 1;
    System.out.printf("당신이 입력한 숫자에 1을 더하면 %.2f 입니다.", result);
  }
}