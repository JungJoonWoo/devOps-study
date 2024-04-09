package day9.chapter7;

public interface MyInterface {
  void sayHello();

  default void say() {
    System.out.println("hello");
  }
}

class Hello implements MyInterface {

  @Override
  public void sayHello() {
    System.out.println("Hello");
  }
}

class GoodBye implements MyInterface {
  @Override
  public void sayHello() {
    System.out.println("goodbye");
  }
}

class Say implements MyInterface {
  @Override
  public void sayHello() {
    System.out.println("say");
  }

  @Override
  public void say() {
    System.out.println("say something");
  }
}