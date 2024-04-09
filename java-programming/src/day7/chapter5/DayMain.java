package day7.chapter5;

import java.util.Scanner;

public class DayMain {
  public static void main(String[] args) {

    Day day;
    Scanner sc = new Scanner(System.in);

    try {
      day = Day.valueOf(sc.nextLine().toUpperCase());
    } catch (Exception e) {
      System.err.println(e);
      System.out.println("존재하지 않는 요일");
      return;
    }

    if (day == Day.SATURDAY || day == Day.SUNDAY) {
      System.out.println("주말입니다");
    } else {
      System.out.println("주중입니다.");
    }
  }
}