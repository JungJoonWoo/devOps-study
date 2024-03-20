package day12.chapter11.Ex3;

import java.util.Hashtable;
import java.util.Scanner;

public class HashTableMain {
  public static void main(String[] args) {
    Hashtable<String, Integer> table = new Hashtable<>();
    table.put("김열공", 20);
    table.put("최고봉", 56);
    table.put("우등생", 16);
    table.put("나자바", 35);

    Scanner sc = new Scanner(System.in);
    System.out.print("이름을 입력하시오: ");
    System.out.println(table.get(sc.nextLine()));
  }
}