package day7.chapter5;

public class EnumDemo {

  public static void main(String[] args) {
    Gender gender = Gender.FEMALE;
    if (gender.equals(Gender.FEMALE)) {
      System.out.println(gender + " AAA");
    }

    Direction direction = Direction.EAST;
    if (direction.equals(direction.EAST)) {
      System.out.println(direction);
    }
  }
}