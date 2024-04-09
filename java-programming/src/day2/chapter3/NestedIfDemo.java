package day2.chapter3;

import java.util.Scanner;

public class NestedIfDemo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("점수를 입력하세요: ");
    int score = sc.nextInt();
    String grade = "";
    if (score > 90) {
      grade = "A";
      if (score > 96) {
        grade = "A+";
      }
    }
    System.out.println(grade);
  }
}