package day8.Ex4;

public class Child extends Parent {
  private String name = "사도세자";

  @Override
  public void print() {
    System.out.println("name = " + name);
  }
}