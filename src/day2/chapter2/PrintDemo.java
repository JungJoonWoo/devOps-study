package day2.chapter2;

import java.util.Scanner;

public class PrintDemo {
  public static void main(String[] args) {
    int i = 3;
    double d = 3.14;
    System.out.printf("i = %d and d = %.2f\n", i,d);
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();

    int a = sc.nextInt();

    String s2 = sc.nextLine();
    String s3 = sc.nextLine();

    System.out.println("a = " + a);
    System.out.println("s = " + s);
    System.out.println("s2 = " + s2);
    System.out.println("s3 = " + s3);
  }
}