package day7.chapter5;

import java.util.Arrays;
import java.util.Random;

public class Ex4 {
  public static void main(String[] args) {
    String[] name = {"가위", "바위", "보"};
    Random random = new Random();
    int randNum = 0;

    System.out.println(name);
    System.out.println(Arrays.toString(name));

    for (int i = 0; i < 10; i++) {
      randNum = random.nextInt(3);
      System.out.println(name[randNum]);
    }
  }
}