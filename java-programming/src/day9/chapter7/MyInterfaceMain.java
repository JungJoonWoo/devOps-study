package day9.chapter7;

public class MyInterfaceMain {
  public static void main(String[] args) {

    Hello hello = new Hello() {

      @Override
      public void sayHello() {
        System.out.println("익명 클래스 선언");
      }
    };
    GoodBye goodBye = new GoodBye();
    Say say = new Say();

    hello.sayHello();
    hello.say();

    goodBye.sayHello();
    goodBye.say();

    say.sayHello();
    say.say();

  }
}