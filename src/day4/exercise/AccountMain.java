package day4.exercise;

import java.util.Scanner;

public class AccountMain {
  public static void main(String[] args) {
    // 계좌 번호 중복 방지 -> 계좌번호를 static list로 만들고 만들때 마다 있는지 확인, 있다면 다시 입력받기.
    Scanner sc = new Scanner(System.in);

    System.out.println("새로운 계좌번호, 비밀번호,  예금주 이름,  금액을 입력");

    Account account = new Account(sc.next(), sc.next(), sc.next(), sc.nextLong());
    sc.nextLine();

    AccountService as = new AccountService(account);

    System.out.println("출금할 계좌번호, 비밀번호 입력");

    if (!as.checkValiable(sc.next(), sc.next())) {
      System.out.println("계좌번호 혹은 비밀번호가 틀림");
      return;
    }

    System.out.println("입금, 출금 금액 입력");
    as.deposit(sc.nextLong());

    as.withdraw(sc.nextLong());

    as.checkBalance();

    as.changePassword();
  }
}