package day8.chapter6.Ex4;

import day8.chapter6.Ex4.Parent;

public class Child extends Parent {
  private String name = "사도세자";

  @Override
  public void print() {
    System.out.println("name = " + name);
  }
}