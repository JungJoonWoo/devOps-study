package day7.chapter6;

public class CircleMain {
  public static void main(String[] args) {
    Circle c1 = new Cylinder(10,"white", 10);
    c1.findArea();
    Circle c2 = new Ball(100, "Black");
    c2.findArea();
  }
}