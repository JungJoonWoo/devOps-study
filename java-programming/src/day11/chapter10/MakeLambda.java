package day11.chapter10;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class MakeLambda {
  public static void main(String[] args) {

    MyFunction f1 = (x, y) -> x > y ? x : y;

    int max1 = f1.max(900, 400);
    System.out.println("max1 = " + max1);

//    MyFunction f = new MyFunction() {
//
//      @Override
//      public int max(int a, int b) {
//        return a > b ? a : b;
//      }
//    };


//    int max = f.max(10, 40);
//    System.out.println("max = " + max);



//    Object obj = new Object() {
//      int max(int a, int b) {
//        return a > b ? a : b;
//      }
//    };
//    (a, b) -> (a < b) ? a : b;
//    (String name, int i) -> System.out.println(name + "=" + i);
//    x -> x * x;

    List<String> list = Arrays.asList("aaa", "gdsf", "sfsf", "wfsafsd");
    list.sort((s1, s2) -> s2.compareTo(s1));
    System.out.println(list.toString());
    Collections.sort(list, (s1, s2) -> s2.compareTo(s1));

    Collections.sort(list);


    Comparator<String> c1 = (o1, o2) -> o2.length() - o1.length();
    System.out.println(c1.compare("a12bcde", "12323"));
  }
}

@FunctionalInterface
interface MyFunction {
  int max(int a, int b);
}