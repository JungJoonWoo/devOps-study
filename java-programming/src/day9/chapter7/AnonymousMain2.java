package day9.chapter7;

public class AnonymousMain2 {

  public static void main(String[] args) {

    Bird eagle = new Bird() {
      @Override
      public void move() {
        System.out.println("Eagle.move");
      }
    };
    eagle.move();
  }
}