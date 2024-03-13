package day6.chapter5.Account;

public class Account {
  private final String accountNo;
  private String password;
  private long balance;
  private final String name;


  Account(String accountNo, String password, String name, long balance) {
    this.accountNo = accountNo;
    this.password = password;
    this.balance = balance;
    this.name = name;
  }

  public void setPassword(String password) {
    if (password == null) {
      System.out.println("심각한 문제 발생");
      return;
    }
    this.password = password;
  }

  public void setBalance(long balance) {
    if (balance <= 0) {
      System.out.println("심각한 문제 발생");
      return;
    }
    this.balance = balance;
  }

  public String getAccountNo() {
    return accountNo;
  }

  public String getPassword() {
    return password;
  }

  public long getBalance() {
    return balance;
  }

  public String getName() {
    return name;
  }
}