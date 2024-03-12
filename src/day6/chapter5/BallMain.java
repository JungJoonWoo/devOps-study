package day6.chapter5;

public class BallMain {
  public static void main(String[] args) {
    BallService ballService = new BallService();
    ballService.makeBall(10, "White");
    ballService.makeBall(10, "Black");
    ballService.makeBall(20, "Red");
    
  }
}