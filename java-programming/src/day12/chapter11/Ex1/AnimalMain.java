package day12.chapter11.Ex1;

import java.util.ArrayList;

public class AnimalMain {
  public static void main(String[] args) {
    ArrayList<String> animals = new ArrayList<>();
    animals.add("갈매기");
    animals.add("나비");
    animals.add("다람쥐");
    animals.add("라마");

    animals.stream().filter(animal -> animal.length() == 2).forEach(System.out::println);
  }
}