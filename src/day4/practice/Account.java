package day4.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Account {
  private static final Map<String, Account> accounts = new HashMap<>();//숫자 5자리
  private String name;//예금주 이름
  private String password;//숫자 4자리
  private long balance;//잔액

  public Account() {
  }

  public Account(String name, String password, long balance) {
    this.name = name;
    this.password = password;
    this.balance = balance;
  }

  public Account(String accountNo, String password, String name, long balance) {
    while (accounts.containsKey(accountNo)) {
      Scanner sc = new Scanner(System.in);
      System.out.print("이미 존재하는 계좌번호입니다. 다시 입력하세요");
      accountNo = sc.nextLine();
    }
    accounts.put(accountNo, this);
    this.password = password;
    this.name = name;
    this.balance = balance;
  }

  public Account accountMap(String accountNo, String password, String name, long balance) {
    while (accounts.containsKey(accountNo)) {
      Scanner sc = new Scanner(System.in);
      System.out.print("이미 존재하는 계좌번호입니다. 다시 입력하세요");
      accountNo = sc.nextLine();
    }
    accounts.put(accountNo, new Account(password, name, balance));
    return this;
  }

  public boolean changePw(String accountNo, String oldPw) {
    if (Account.accounts.containsKey(accountNo)) {
      Account tempAccount = Account.accounts.get(accountNo);
      if (tempAccount.getPassword().equals(oldPw)) {
        Scanner sc = new Scanner(System.in);
        System.out.print("변경할 비밀번호를 입력: ");
        tempAccount.setPassword(sc.next());
        return true;
      }
    }
    return false;
  }

  public boolean deposit(String accountNo, Long amount) {
    if (Account.accounts.containsKey(accountNo)) {
      Account tempAccount = Account.accounts.get(accountNo);
      tempAccount.balance += amount;
      return true;
    }
    return false;
  }

  public boolean withdraw(String accountNo, Long amount) {
    if (Account.accounts.containsKey(accountNo)) {
      Account tempAccount = Account.accounts.get(accountNo);
      long b = tempAccount.getBalance();
      if (b < amount) {
        return false;
      }
      tempAccount.balance -= amount;
      return true;
    }
    return false;
  }

  public boolean checkBalance(String accountNo) {
    if (Account.accounts.containsKey(accountNo)) {
      System.out.println(Account.accounts.get(accountNo).getBalance());
      return true;
    }
    return false;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public long getBalance() {
    return balance;
  }

  public void setBalance(long balance) {
    this.balance = balance;
  }
  
}