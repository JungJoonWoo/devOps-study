package day6.chapter5;

import day6.chapter5.Account.AccountService;

import java.util.Scanner;

public class AccountMain {
  public static void main(String[] args) {
    AccountService accountService = new AccountService();
    int input = 0;
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("1. 계좌 생성, 2. 입금, 3. 출금, 4. 비밀번호 변경, 5. 잔액 확인, 6. 종료");
      input = sc.nextInt();
      switch (input) {
        case 1 -> {
          accountService.makeAccount();
        }
        case 2 -> {
          accountService.deposit();
        }
        case 3 -> {
          accountService.withdraw();
        }
        case 4 ->{
          accountService.changePw();
        }
        case 5 -> {
          accountService.checkBalance();
        }
        case 6 -> {
          System.out.println("프로그램 종료");
          return;
        }
        default -> {
          System.out.println("1 ~ 6 사이의 값을 입력하세요.");
        }
      }
    }

  }
}