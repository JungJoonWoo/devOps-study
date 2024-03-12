package day5.chapter5;

import java.util.Arrays;

public class ArrayDemo {

  public static void main(String[] args) {
    String[] strArrs = {"aaa", "bbb", "ccc"};
    System.out.println(strArrs.length);
    Arrays.stream(strArrs)
        .forEach(System.out::println);

    for (String data : strArrs) {
      System.out.println(data);
    }
    System.out.println(Arrays.toString(strArrs));
    System.out.println(Arrays.toString(strArrs).join(", ", strArrs));
    System.out.println(String.join(", ", strArrs));

    float[] fArrs = {1.1f, 2.2f, 3.3f};
    double[] fArrs1 = {1.1, 2.2, 3.3};

    for (float fArr : fArrs) {
      System.out.println(fArr);
    }
    System.out.println(Arrays.toString(fArrs));

    Arrays.stream(fArrs1).forEach((fArr) -> System.out.println(fArr));
  }

}