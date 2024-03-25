package day15.chapter14;

public class NoThreadMain {
  public static void main(String[] args) throws InterruptedException {

    Thread th1 = new Thread(new Runnable() {
      @Override
      public void run() {

        for (int i = 0; i < 5; i++) {
          System.out.println("hello");
          try {
            Thread.sleep(200);
          } catch (InterruptedException e) {

          }
        }
      }
    });
    th1.start();


    Thread th2 = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("bye");
        for (int i = 0; i < 5; i++) {
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {

          }
        }
      }
    });

    th2.start();

    for (int i = 0; i < 5; i++) {
      System.out.println("main");
      Thread.sleep(500);
    }

  }
}