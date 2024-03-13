package day3.chapter3;

import java.util.Scanner;
import java.util.function.Function;

public class MethodDemo3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("점수를 입력하세요: ");
    int score = sc.nextInt();
    if (checkScore(score)) {
      Function<Integer, String> grade = checkGrade();
      System.out.println(grade.apply(score));
    } else {
      System.out.println("입력값이 잘못 되었음");
    }
  }

  private static Function<Integer, String> checkGrade() {
    return (score) -> {
      if (score >= 90) return "A";
      else if (score >= 80) return "B";
      else if (score >= 70) return "C";
      else return "F";
    };
  }

  private static boolean checkScore(int score) {
    return score >= 0 && score <= 100;
  }

}