package day1;

public class NumberTypeDemo2 {
  public static void main(String[] args) {

    double radius = 10.0;
    double pi = 3.14;

    double area = Math.pow(radius, 2) * Math.PI;

    System.out.println("반지름이 " + radius + "인 원의 넓이는 " + area + "이다");
    System.out.println("반지름이 " + radius + "인 원의 넓이는 " + Math.pow(radius, 2) * pi + "이다");

  }
}