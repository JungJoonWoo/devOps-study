package day6.chapter5;

import java.util.ArrayList;
import java.util.List;

public class BallService {
  List<Ball> balls = new ArrayList<>();

  public void makeBall(int radius, String color) {
    if (balls.stream().anyMatch(s -> s.getRadius() == radius)) {
      System.out.println("이미 존재하는 반지름");
      return;
    }
    balls.add(new Ball(radius, color));
    System.out.println("정상적으로 추가");
  }
}