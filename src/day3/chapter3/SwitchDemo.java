package day3.chapter3;

import java.util.Scanner;

public class SwitchDemo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    ex1(sc);

    ex2(sc);

  }

  private static void ex2(Scanner sc) {
    String grade = "";
    int score = sc.nextInt();
//    switch (score) {
//      case 90:
//        grade = "A";
//        break;
//      case 80:
//        grade = "B";
//        break;
//      case 70:
//        grade = "C";
//        break;
//      default:
//        grade = "F";
//    }
//    System.out.println("grade = " + grade);
  }

  private static void ex1(Scanner sc) {
    int score = sc.nextInt();
//    String grade = switch (score) {
//      case 90 -> "A";
//      case 80 -> "B";
//      case 70 -> "C";
//      default -> "F";
//    };
//    System.out.println("grade = " + grade);
  }
}