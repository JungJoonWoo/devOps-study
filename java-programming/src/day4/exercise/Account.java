package day4.exercise;

public class Account {
  private String accountNo;//숫자 5자리
  private final String name;//예금주 이름
  private String password;//숫자 4자리
  private long balance;//잔액

  public Account(String accountNo, String password, String name, long balance) {

    this.accountNo = accountNo;
    this.password = password;
    this.name = name;
    this.balance = balance;
  }

  public String getAccountNo() {
    return accountNo;
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