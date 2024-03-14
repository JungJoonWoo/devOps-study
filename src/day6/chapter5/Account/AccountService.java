package day6.chapter5.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AccountService {
  List<Account> accounts = new ArrayList<>();

  //계좌 생성
  public void makeAccount() {
    Scanner sc = new Scanner(System.in);
    System.out.print("생성할 계좌의 계좌 번호, 비밀번호, 이름, 초기 입금 금액을 입력: ");
    String accountNo = sc.next();
    String pw = sc.next();
    String name = sc.next();
    long amount = sc.nextLong();

    if (accounts.stream().anyMatch(account -> account.getAccountNo().equals(accountNo))) {
      System.out.println("계좌 생성 실패(계좌 번호 중복)");
      return;
    }
    accounts.add(new Account(accountNo, pw, name, amount));
    System.out.println("계좌 생성 성공");
  }

  //입금
  public void deposit() {
    System.out.print("입금할 계좌와 비밀번호를 입력: ");
    Scanner sc = new Scanner(System.in);
    String accountNo = sc.next();
    String pw = sc.next();
    if (accounts.stream().anyMatch(account -> {
      boolean b = account.getAccountNo().equals(accountNo) && account.getPassword().equals(pw);
      return b;
    })) {
      System.out.print("확인완료. 입금할 금액을 입력하시오: ");
      do {
        long amount = sc.nextLong();
        if (amount <= 0) {
          System.out.print("정확한 값을 다시 입력하시오: ");
          continue;
        }
        Optional<Account> optionalAccount = accounts.stream().filter(account -> account.getAccountNo().equals(accountNo)).findFirst();
        Account account = optionalAccount.get();
        account.setBalance(account.getBalance() + amount);
        System.out.println("입금 성공");
        break;
      } while (true);

    } else {
      System.out.println("계좌가 존재하지 않거나 비번이 틀림");
    }
  }

  //출금
  public void withdraw() {
    System.out.print("출금할 계좌와 비밀번호를 입력: ");
    Scanner sc = new Scanner(System.in);
    String accountNo = sc.next();
    String pw = sc.next();
    if (accounts.stream().anyMatch(account -> {
      boolean b = account.getAccountNo().equals(accountNo) && account.getPassword().equals(pw);
      return b;
    })) {
      System.out.print("확인완료. 출금할 금액을 입력하시오: ");
      do {
        long amount = sc.nextLong();
        if (amount <= 0 || accounts.stream().filter(account -> account.getAccountNo().equals(accountNo)).findFirst().get().getBalance() < amount) {
          System.out.print("정확한 값을 다시 입력하시오: ");
          continue;
        }
        Optional<Account> optionalAccount = accounts.stream().filter(account -> account.getAccountNo().equals(accountNo)).findFirst();
        Account account = optionalAccount.get();
        account.setBalance(account.getBalance() - amount);
        System.out.println("출금 성공");
        break;
      } while (true);

    } else {
      System.out.println("계좌가 존재하지 않거나 비번이 틀림");
    }
  }

  //계좌 잔고
  public void checkBalance() {
    System.out.print("확인할 계좌와 비밀번호를 입력: ");
    Scanner sc = new Scanner(System.in);
    String accountNo = sc.next();
    String pw = sc.next();
    if (accounts.stream().anyMatch(account -> {
      return account.getAccountNo().equals(accountNo) && account.getPassword().equals(pw);
    })) {
      System.out.println("확인완료.");
      System.out.println("잔액: " + accounts.stream().filter(account -> account.getAccountNo().equals(accountNo)).findFirst().get().getBalance());
    } else {
      System.out.println("계좌가 존재하지 않거나 비번이 틀림");
    }
  }

  //비번변경
  public void changePw() {
    System.out.print("비밀번호를 변경할 계좌와 비밀번호를 입력: ");
    Scanner sc = new Scanner(System.in);
    String accountNo = sc.next();
    String pw = sc.next();
    if (accounts.stream().anyMatch(account -> {
      return account.getAccountNo().equals(accountNo) && account.getPassword().equals(pw);
    })) {
      System.out.print("확인완료. 변경할 비밀번호를 입력하시오: ");
      do {
        String changeName = sc.next();
        if (changeName.isEmpty() || accounts.stream().filter(account -> account.getAccountNo().equals(accountNo)).findFirst().get().getPassword().equals(changeName)) {
          System.out.print("정확한 값을 다시 입력하시오: ");
          continue;
        }
        Optional<Account> optionalAccount = accounts.stream().filter(account -> account.getAccountNo().equals(accountNo)).findFirst();
        Account account = optionalAccount.get();
        account.setPassword(changeName);
        System.out.println("비밀번호 변경 성공");
        break;
      } while (true);

    } else {
      System.out.println("계좌가 존재하지 않거나 비번이 틀림");
    }
  }
}