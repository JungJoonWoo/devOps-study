package day4.exercise;


/**
 * 이름 아이디 패스워드 나이
 * 멤버 클래스 선언
 */
public class Member {

  private final String name;//final
  private final String id;//final
  private String password;//not final
  private int age;//not final

  public Member(String name, String id) {
    this.name = name;
    this.id = id;
  }

  public boolean login(String id, String password) {
    if ((id.equals("Hong") || id.equals("hong")) && password.equals("12345")) {
      return true;
    }
    return false;
  }

  public boolean logout(String id) {
    if (id.equals("Hong") || id.equals("hong")) {
      return true;
    }
    return false;

  }

  public String getName() {
    return name;
  }

  public String getId() {
    return id;
  }
}