package day4.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemberMain {
  public static void main(String[] args) throws IOException {

    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("ID: ");
    String id = r.readLine();

    System.out.print("Password: ");
    String pw = r.readLine();

    Member member2 = new Member("홍갈동", id);

    boolean isLogin = member2.login(member2.getId(), pw);

    if (isLogin) {
      boolean isLogout = member2.logout(member2.getId());
      System.out.println("로그인 성공");

      if (isLogout) {
        System.out.println("로그아웃 성공");
      } else {
        System.out.println("로그아웃 실패");
      }
    } else {
      System.out.println("로그인 실패");
    }

    r.close();
  }
}