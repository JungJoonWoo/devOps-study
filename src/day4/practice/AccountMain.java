package day4.practice;
import java.util.Scanner;

public class AccountMain {
  public static void main(String[] args) {
    // 계좌 번호 중복 방지 -> 계좌번호를 static list로 만들고 만들때 마다 있는지 확인, 있다면 다시 입력받기.
    Scanner sc = new Scanner(System.in);
    int select = 0;

    Account account = new Account();
    System.out.println("새로운 계좌번호, 비밀번호,  예금주 이름,  금액을 입력");
    account = account.accountMap(sc.next(), sc.next(), sc.next(), sc.nextLong());
    do {
      System.out.println("1. 계좌 생성, 2. 입금, 3. 출금, 4. 잔액 확인, 5. 비밀번호 변경, 6. 종료");
      select = sc.nextInt();
      switch (select) {

        case 1 -> {
          System.out.println("새로운 계좌번호, 비밀번호,  예금주 이름,  금액을 입력");
          account = new Account(sc.next(), sc.next(), sc.next(), sc.nextLong());
        }
        case 2 -> {
          System.out.print("입금할 계좌 번호 및 금액: ");
          if (account.deposit(sc.next(), sc.nextLong())) {
            System.out.println("입금완료");
          } else {
            System.out.println("입금실패");
          }
        }
        case 3 -> {
          System.out.print("출금할 계좌, 금액 입력: ");
          account.withdraw(sc.next(), sc.nextLong());
        }
        case 4 -> {
          System.out.print("확인할 계좌: ");
          account.checkBalance(sc.next());
        }
        case 5 -> {
          System.out.print("비밀번호를 변경하는 계좌와 기존 비밀번호: ");
          if (account.changePw(sc.next(), sc.next())) {
            System.out.println("비밀번호 변경 완료");
          } else {
            System.out.println("비밀번호 변경 실패");
          }
        }
      }
    } while (select != 6);
  }
}