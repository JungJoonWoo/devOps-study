package day8.chapter6.Ex5;

public class Phone {
  protected String owner;

  public Phone(String owner) {
    this.owner = owner;
  }

  public String getOwner() {
    return owner;
  }

  public void talk() {
    System.out.println(owner + "가 통화중");
  }
}