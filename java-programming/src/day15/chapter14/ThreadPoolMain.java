package day15.chapter14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolMain {
  public static void main(String[] args) {
    Runnable task = () -> {
      for (int i = 0; i < 5; i++) {
        System.out.println("Good Bye");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    };
    
    ExecutorService thPool = Executors.newFixedThreadPool(4);
    thPool.execute(task);

    for (int i = 0; i < 5; i++) {
      System.out.println("Hello");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    thPool.shutdown();
  }
}