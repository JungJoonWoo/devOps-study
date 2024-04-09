package day11.chapter10;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class UtilFunctionMain {
  public static void main(String[] args) {
//    Runnable r = (x, y) -> x + y;
    Supplier<Double> s = () -> Math.random();
    double rand = s.get();
    System.out.println("rand = " + rand);

    String[] strings = {"aaa", "ccc", "bbb"};
    Consumer<String> cs = string -> System.out.println(string);
    cs.accept("HelloWorld");
    //    r.run();
  }
}