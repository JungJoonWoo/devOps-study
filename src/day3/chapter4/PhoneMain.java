package day3.chapter4;

public class PhoneMain {
  public static void main(String[] args) {
    Phone p = new Phone();
    Phone samPhone = new SamsungPhone();
    p.print();
    samPhone.print();
  }
}