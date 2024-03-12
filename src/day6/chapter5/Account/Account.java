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
    this.password = password;
  }

  public void setBalance(long balance) {
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