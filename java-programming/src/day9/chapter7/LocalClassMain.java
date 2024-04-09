package day9.chapter7;

public class LocalClassMain {
  public static void main(String[] args) {
    class Eagle implements Bird {

      @Override
      public void move() {
        System.out.println("Eagle.move");
      }
    }

    Eagle e = new Eagle();
    e.move();
    new Bird(){
      @Override
      public void move() {
        System.out.println("LocalClassMain.move");
      }
    }.move();

    ((Bird) () -> System.out.println("LocalClassMain.move")).move();
    ((Bird) () -> System.out.println("Bird")).move();
  }
}