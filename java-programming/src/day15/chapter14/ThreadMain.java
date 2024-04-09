package day15.chapter14;

public class ThreadMain {
  public static void main(String[] args) {
    new WorkerThread().start();
    new WorkerThread().start();
    new WorkerThread().start();
    new WorkerThread().start();
    new WorkerThread().start();

    for (int i = 0; i < 5; i++) {
      System.out.println("Hello");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

class WorkerThread extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("Good Bye");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}