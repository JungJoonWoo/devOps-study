package day5.chapter5;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      list.add(Character.toString('a' + i));
    }
    list.forEach(System.out::println);
  }
}