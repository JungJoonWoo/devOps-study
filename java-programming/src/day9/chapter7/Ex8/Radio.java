package day9.chapter7.Ex8;

public class Radio extends Controller{
  public Radio(boolean power) {
    super(power);
  }


  @Override
  void show() {
    if (isPower()) {
      System.out.println("Radio가 켜졌습니다.");
    } else {
      System.out.println("Radio가 꺼졌습니다.");
    }
  }
}