package day8;

public class InstanceofDemo3 {
  public static void main(String[] args) {
    Person p1 = new Person("11111");
    Person p2 = new Person("11111");
    Person p3 = new Person("22222");

    System.out.println(p1.equals(p2));
    System.out.println(p1.equals(p3));

  }
}