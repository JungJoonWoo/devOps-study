package day3.chapter3;

import java.util.Scanner;

public class Ex1 {
  public static void main(String[] args) {
    accountManagement();
  }

  private static void accountManagement() {
    Scanner sc = new Scanner(System.in);
    int menu = 0;
    long account = 0L;

    do {
      System.out.print("1. 입금, 2. 출금, 3. 잔고, 4. 종료\n메뉴를 선택하세요: ");

      menu = sc.nextInt();
      System.out.println();

      switch (menu) {
        case 1 -> {
          System.out.print("입금할 금액을 입력하세요:");
          long input = sc.nextLong();
          System.out.println();

          if (input > 0) {
            account += input;
          } else {
            System.out.println("올바른 값을 입력하시오.");
          }
        }

        case 2 -> {
          if (account == 0) {
            System.out.println("잔액이 0원 입니다.\n");
            continue;
          }
          System.out.print("출금할 금액을 입력하세요: ");
          long input = sc.nextLong();
          System.out.println();

          if (input < account && input > 0) {
            System.out.println("출금 전 계좌 잔고: " + account);
            System.out.println("출금 금액: " + input);
            account -= input;
            System.out.println("출금 후 계좌 잔고: " + account);
            System.out.println();
          } else {
            System.out.println("올바른 값을 입력하세요");
            System.out.println("계좌 잔고: " + account);
            System.out.println();
          }
        }
        case 3 -> {
          System.out.println("계좌 잔고: " + account);
          System.out.println();
        }
        case 4 -> {
          System.out.println("종료.");
        }
        default -> System.out.println("올바른 메뉴를 선택하세요.\n");
      }
    } while (menu != 4);
  }
}