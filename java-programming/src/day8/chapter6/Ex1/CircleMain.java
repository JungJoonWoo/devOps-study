package day8.chapter6.Ex1;

public class CircleMain {
  public static void main(String[] args) {
    Circle c1 = new Circle(5);
    Circle c2 = new ColoredCircle(10, "white");

    c1.show();
    c2.show();
  }
}