package day11.chapter9;

public class ExceptionThrowsMain {
  public static void main(String[] args) {
    square("10aa");
  }

  private static void square(String s) throws NumberFormatException{
    int i = Integer.parseInt(s);
    System.out.println(i * i);
  }
}