package day11.chapter9;

public class ExceptionMain {
  public static void main(String[] args) {
    ArithmeticException e = new ArithmeticException("ERROR");
    System.out.println((e.getMessage()));
    e.printStackTrace();
  }
}