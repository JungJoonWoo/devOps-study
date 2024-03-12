package day1;

public class NumberTypeDemo {
  public static void main(String[] args) {
    byte b1 = 10;
    byte b2;

    short s1 = 600;
    short s2;

    int i1 = 2_000_000_000;
    int i2;

    long l1 = 10000000000L;
    long l2;

    System.out.println(b1);
    System.out.println(s1);
    System.out.println(i1);
    System.out.println(l1);

    char c1 = 'a';
    System.out.println(c1);

    float f1 = 0f;
    System.out.println(f1);

    double d1 = 0;
    System.out.println(d1);

    boolean bool = true;
    System.out.println(bool);

    int a = 100;
    a = '정';
    System.out.println(a);
  }
}