package day3.chapter3;

public class Ex2 {
  public static void main(String[] args) {
    divide(10,20,30,40,50,60,70);
  }

  private static int divide(int num1, int num2) {
    return num1 / num2;
  }

  private static void divide(int... numbers) {
    for (int number : numbers) {
      System.out.println(number);
    }
  }
}