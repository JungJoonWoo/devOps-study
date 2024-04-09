package day4.chapter4;

public class CarMain {
  public static void main(String[] args) {
    Car car1 = new Car("소나타", "흰색");

    CarService cs1 = new CarService(car1);

    System.out.println("Serial Num: " + car1.getSerialNumber());
    cs1.go();
    cs1.setDirection();
    cs1.go();
    cs1.show();
    Car car2 = new Car("소나타", "흰색");
    CarService cs2 = new CarService(car2);
    System.out.println(car2.getSerialNumber());
    cs2.show();
    Car car3 = new Car("소나타", "흰색");
    CarService cs3 = new CarService(car3);
    System.out.println(car3.getSerialNumber());
    cs3.show();
  }
}