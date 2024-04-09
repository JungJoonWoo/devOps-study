package day13.chapter12;

public class Util {
  public static <T> void print(T t) {
    System.out.printf(t + " ");
  }

  public static <T> void printWithParenthesis(T t) {
    System.out.printf("(" + t + ")");

  }
}