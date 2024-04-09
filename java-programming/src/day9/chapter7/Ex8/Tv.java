package day9.chapter7.Ex8;

public class Tv extends Controller {

  public Tv(boolean power) {
    super(power);
  }

  @Override
  void show() {
    if (isPower()) {
      System.out.println("Tv가 켜졌습니다.");
    } else {
      System.out.println("Tv가 꺼졌습니다.");
    }
  }
}