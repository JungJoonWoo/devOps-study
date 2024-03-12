package day4.chapter4;

public class CircleDemo {
  public static void main(String[] args) {
    Circle c1 = new Circle(10);
    c1.show();
    Circle c2 = new Circle("Blue");
    c2.show();
    Circle c3 = new Circle(20, "Red");
    c3.show();
    Circle c4 = new Circle();
    c4.show();
  }
}