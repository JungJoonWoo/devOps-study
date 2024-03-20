package day12.chapter11.Ex5;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AnimalMain {
  public static void main(String[] args) {
    Map<String, String> animals = new HashMap<>();
    animals.put("호랑이", "tiger");
    animals.put("표범", "leopard");
    animals.put("사자", "lion");

    System.out.println("변경 전: " + animals);
    animals.replaceAll((a1, a2) -> a2.toUpperCase());
    System.out.println("변경 후: " + animals);

  }
}