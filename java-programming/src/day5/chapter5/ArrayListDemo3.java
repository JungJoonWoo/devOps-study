package day5.chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListDemo3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Integer> scores = new ArrayList<>();

    out: while (true) {

      int score = sc.nextInt();
      if (score <= 0) {
        break out;
      }
      scores.add(score);
    }
    int sum = scores.stream().mapToInt(score -> score).sum();
    System.out.println("sum = " + sum);
    double avg = (double)sum / scores.size();
    System.out.println("avg = " + avg);
  }
}