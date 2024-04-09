package day12.chapter11.Ex4;

import java.util.*;

public class StudentMain {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    List<Integer> score = new ArrayList<>();
    while (true) {
      System.out.print("점수를 입력하세요: ");
      int input = sc.nextInt();
      if (input < 0) {
        Exception e = new RuntimeException();
        System.out.println(e);
        break;
      }
      score.add(input);

    }
    System.out.printf("전체 학생은 %d명이다.\n", score.size());
    System.out.print("학생들의 성적: ");
    score.forEach(s -> System.out.print(s + " "));
    System.out.println();
    int max = Collections.max(score);
    for (int i = 0; i < score.size(); i++) {
      int s = score.get(i);
      if (s > max - 10) {
        System.out.printf("%d번째 학생의 성적은 %d이며 등급은 A이다\n", i, s);
      }else if (s > max - 20) {
        System.out.printf("%d번째 학생의 성적은 %d이며 등급은 B이다\n", i, s);
      } else if (s > max - 30) {
        System.out.printf("%d번째 학생의 성적은 %d이며 등급은 C이다\n", i, s);
      } else {
        System.out.printf("%d번째 학생의 성적은 %d이며 등급은 D이다\n", i, s);

      }
    }
  }
}