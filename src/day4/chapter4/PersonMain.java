package day4.chapter4;

public class PersonMain {
  public static void main(String[] args) {
    Person p1 = new Person();
    p1.setName("홍길동");
    p1.setAge(22);

    p1.sayHello();

    p1.setName("ww").setAge(21).sayHello();
  }
}