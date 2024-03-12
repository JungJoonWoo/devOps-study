package day2.chapter3;

public class Ex3 {
  public static void main(String[] args) {
    for (int i = 0; i < 6; i++) {
      int randomNum = ((int) (Math.random() * 10)) % 6 + 1;
      int r = (int)(Math.random() * 6) + 1;
//      System.out.println("randomNum = " + randomNum);
      System.out.println("r = " + r);
    }
  }
}