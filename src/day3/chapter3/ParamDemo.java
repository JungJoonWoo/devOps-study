package day3.chapter3;

public class ParamDemo {
  public static void main(String[] args) {
    int n = 0;
    System.out.println("메소드 호출 전 n = " + n);
    increment(n);
    System.out.println("메소드 호출  n = " + n);
  }

  private static void increment(int n) {
    n++;
  }

}