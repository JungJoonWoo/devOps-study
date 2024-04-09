package day10.chapter8.Ex1;

public class CircleMain {
  public static void main(String[] args) {
    Circle[] c = {new Circle(3), new Circle(3)};

    if (c[0].getRadius() == c[1].getRadius()) {
      System.out.println("같음");
    } else {
      System.out.println("다름");
    }

  }
}