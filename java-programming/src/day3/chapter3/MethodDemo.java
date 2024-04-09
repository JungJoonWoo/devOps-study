package day3.chapter3;

public class MethodDemo {
  public static void main(String[] args) {
    int a, b, c;
    a = calculate(0, 10);
    System.out.println("a = " + a);

    b = calculate(10, 100);
    System.out.println("b = " + b);

    c = calculate(100, 1000);
    System.out.println("c = " + c);
  }

  private static int calculate(int num1, int num2) {
    int sum = 0;
    for (int i = num1; i < num2; i++) {
      sum += i;
    }
    return sum;
  }
}