package day2.chapter2;

import java.util.Scanner;

public class ScannerDemo {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    sc.nextLine();

    String s = sc.nextLine();

    System.out.println(a + "\n" + b + s);

  }
}