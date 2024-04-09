package day11.chapter10;

@FunctionalInterface
interface Mathmetical {
  double calculate(double d);
}

@FunctionalInterface
interface NewArray<T> {
  T[] getArray(int size);

}

public class MethodRefMain {
  public static void main(String[] args) {
    Mathmetical m = Math::cos;
    System.out.println(m.calculate(30));

  }

}