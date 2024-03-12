package day2.chapter2;

public class OpDemo {
  public static void main(String[] args) {
    int x, y;
    x = y = 5;
    int z = ++x + --y / x;
    System.out.println(z);

    x = y =3;
    z = x++ + --y * x;
    System.out.println(z);
  }
}