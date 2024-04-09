package day6.chapter5;

import java.util.Arrays;
import java.util.List;

public class MinMaxDemo {
  public static void main(String[] args) {
    int[] arr = {-1, -2131231, 2342342, 1, 123, 4213, 5435, 123, 4356123, 342};

    List<Integer> list = Arrays.stream(arr).boxed().toList();
    list.forEach(System.out::print);

    int min = Arrays.stream(arr).min().getAsInt();
    int max = Arrays.stream(arr).max().getAsInt();

    System.out.println("min = " + min);
    System.out.println("max = " + max);
    double[] arr1 = {0.213, 0.1231, 123.12313, 1235443.899};

    double min1 = Arrays.stream(arr1).min().getAsDouble();
    double max1 = Arrays.stream(arr1).max().getAsDouble();

    System.out.println("min1 = " + min1);
    System.out.println("max1 = " + max1);
  }
}