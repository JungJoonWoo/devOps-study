package day13.chapter12;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayStreamMain {
  public static void main(String[] args) {
    int[] ia = {123, 432, 564, 123456, 1234, 6457};
    IntStream.of(ia).sum();
    Arrays.stream(ia).sum();
    Arrays.stream(ia);

    String[] sa = {"AAA", "BBBB", "CCCCCC"};
    Arrays.stream(sa).findFirst();
    Stream.of(sa).findFirst();
    Arrays.stream(sa);

    double[] da = {1.2, 3.14, 5.231, 6.84};
    DoubleStream.of(da).sum();
    Stream.of(da);
    Arrays.stream(da);
  }
}