package day4.chapter4;

public class CarService {
  Car car;

  public CarService(Car car) {
    this.car = car;
  }

  public void setDirection() {
    car.direction *= -1;
    if (car.direction == 1) {
      System.out.println("변경 전: 후진\n변경 후: 전진");
    } else {
      System.out.println("변경 전: 전진\n변경 후: 후진");
    }
  }

  public void go() {
    if (car.direction == 1) {
      System.out.println("전진");
    } else {
      System.out.println("후진");
    }
  }
  public void show() {
    System.out.printf("차종: %s\nSerial Number: %d\n색깔: %s\n방향(1이면 전진, -1이면 후진): %d\n",
        car.getModel(), car.getSerialNumber(), car.getColor(), car.getDirection());
  }

}