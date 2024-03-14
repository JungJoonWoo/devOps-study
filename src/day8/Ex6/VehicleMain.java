package day8.Ex6;

public class VehicleMain {
  public static void main(String[] args) {
    Car c = new Car("파랑", 200, 10000, 5);
    c.show();
    System.out.println();
    Vehicle v = c;
    v.show();
  }
}