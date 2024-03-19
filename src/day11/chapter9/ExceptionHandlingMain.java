package day11.chapter9;

import java.util.Random;

public class ExceptionHandlingMain {
  public static void main(String[] args) {
    Random r = new Random();
    for (int i = 0; i < 10; i++)
      try {
        {
    int num = r.nextInt(10);
          int result = 10 / num;

          System.out.println(result);
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());;
      }
  }
}