package day12.chapter11;

import java.util.Arrays;
import java.util.List;

public class ListMain {
  public static void main(String[] args) {
//    List<String> animalList = List.of("호랑이", "사자", "표범");
    List<String> animalList = Arrays.asList("호랑이", "사자", "표범", "aaaaaaa", "bbbb");

    animalList.iterator().forEachRemaining(a -> System.out.println(a + " + "));

    animalList.set(0, "앵무새");
    animalList.sort((o1, o2) -> o2.length() - o1.length());
//    animalList.iterator().forEachRemaining(a -> System.out.println(a + " + "));
    animalList.forEach(System.out::println);
//    animalList.remove("사자");
//    animalList.add("앵무새");

    String[] array = animalList.toArray(new String[0]);
    Arrays.stream(array).forEach(System.out::println);
  }
}