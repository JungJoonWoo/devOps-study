package day13.chapter12;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class OptionalMain {
  public static void main(String[] args) {

    OptionalInt i = OptionalInt.of(100);
    OptionalDouble d = OptionalDouble.of(3.14);
    Optional<String> s = Optional.of("Hello");

    System.out.println(i);
    System.out.println(i.getAsInt());

    System.out.println(d);
    System.out.println(d.getAsDouble());

    System.out.println(s);
    System.out.println(s.get());

    System.out.println(divide(10, 10));

    System.out.println(Optional.ofNullable("A"));

    System.out.println(Optional.ofNullable(null));

  }

  static OptionalDouble divide(double x, double y) {
    return y != 0 ? OptionalDouble.of(x / y) : OptionalDouble.empty();
  }
}