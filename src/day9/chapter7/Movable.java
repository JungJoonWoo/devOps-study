package day9.chapter7;

public interface Movable{
  void move();
}

class Car implements Movable {
  int position = 0;
  @Override
  public void move() {
    System.out.println("Car.move");
  }

  public void show() {
    position += 5;
    System.out.println("position = " + position);
  }
}

class CarMain {
  public static void main(String[] args) {
    Movable m = new Car();

    m.move();
    ((Car)m).show();
    ((Car)m).show();
    ((Car)m).show();
  }
}