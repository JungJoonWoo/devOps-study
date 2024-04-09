package day9.chapter7.Ex4;

public class TriangleMain {
  public static void main(String[] args) {
    Triangle t1 = new Triangle(30, 420);
    Triangle t2 = new Triangle(20, 30);

    int n = t1.compareTo(t2);
    switch (n){
      case 1 -> System.out.println(t1.toString());
      case -1 -> System.out.println(t2.toString());
      case 0 -> System.out.println("넓이가 같음");
    }
  }
}