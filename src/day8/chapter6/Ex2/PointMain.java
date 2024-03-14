package day8.chapter6.Ex2;

public class PointMain {
  public static void main(String[] args) {
    Point p1 = new Point(10, 20);

    Point p2 = new MoveablePoint(30, 40, 50, 60);

    System.out.println(p1);
    System.out.println(p2);
  }
}