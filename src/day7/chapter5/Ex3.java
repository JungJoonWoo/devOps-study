package day7.chapter5;

public class Ex3 {
  public static void main(String[] args) {
    String url = "https://java.com";
    checkURL(url);
  }

  static void checkURL(String url) {
    if (url.endsWith("com")) {
      System.out.println("com으로 끝남");
    }
    if (url.contains("java")) {
      System.out.println("java를 포함");
    }

  }
}