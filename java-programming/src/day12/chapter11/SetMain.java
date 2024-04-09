package day12.chapter11;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetMain {
  public static void main(String[] args) {

    Set<String> set = Set.of("Apple", "Banana", "Cherry", "Mango");
    Set<String> hashSet = new HashSet<>(set);
    TreeSet<String> fruits = new TreeSet<>(set);

    System.out.println(hashSet);
    System.out.println(fruits);
    System.out.println(fruits.first());
  }
}