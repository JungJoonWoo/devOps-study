package day4.chapter4;

public class Car {
  private static int sequence;
  private final String model;
  private final int serialNumber;
  private String color;
  //+1이면 전진, -1이면 후진
  int direction;

  public Car(String model, String color) {
    this.model = model;
    sequence++;
    serialNumber = sequence;
    this.color = color;
    this.direction = 1;
  }

  public int getSerialNumber() {
    return serialNumber;
  }


  public String getModel() {
    return model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getDirection() {
    return direction;
  }
}