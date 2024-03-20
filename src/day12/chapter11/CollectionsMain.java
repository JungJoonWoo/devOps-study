package day12.chapter11;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsMain {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("cherry", "apple", "banana", "mango");
    Collections.sort(list);
    System.out.println(list);
  }
}