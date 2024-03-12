package day3.chapter3;

import java.util.Scanner;

public class SwitchDemo2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String animal = sc.nextLine();
    String kind = switch (animal) {
      case "호랑이", "원숭이"   -> "포유류";
      case "참새", "독수리"     -> "조류";
      case "고등어", "참치"     -> "어류";
      default                 -> {
        System.out.println("어이쿠! ");
        yield "...";
      }
    };
    System.out.printf("%s는 %s이다.", animal, kind);
  }
}