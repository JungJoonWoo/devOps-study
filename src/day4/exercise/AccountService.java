package day4.exercise;

import java.util.Scanner;

public class AccountService {
  Account account;

  public AccountService(Account account) {
    this.account = account;
  }

  public void deposit(long amount) {
    if (amount > 0) {
      account.setBalance(account.getBalance() + amount);
      System.out.println("입금 성공");
    } else {
      System.out.println("입금 실패");
    }
  }

  public void withdraw(long amount) {
    if (amount > 0 && amount < account.getBalance()) {
      account.setBalance(account.getBalance() - amount);
      System.out.println("출금 성공");
    } else {
      System.out.println("출금 실패");
    }
  }

  public void checkBalance() {
    System.out.println(account.getBalance());
  }

  public boolean checkValiable(String accountNo, String pw) {
    if (account.getAccountNo().equals(accountNo) && account.getPassword().equals(pw)) {
      return true;
    }
    return false;
  }

  public void changePassword() {
    Scanner sc = new Scanner(System.in);
    System.out.print("이전 비밀번호 입력: ");
    String lastPw = sc.nextLine();
    if (account.getPassword().equals(lastPw)) {
      System.out.print("새로운 비밀번호를 입력: ");
      String newPw = sc.nextLine();
      account.setPassword(newPw);
      System.out.println("변경 선공");
    }
    System.out.println("비밀번호가 틀림");
  }
}