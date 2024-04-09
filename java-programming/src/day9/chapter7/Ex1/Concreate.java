package day9.chapter7.Ex1;

public class Concreate extends AbstractTest {

  int i;

  public Concreate(int i, int i1) {
    super(i);
    this.i = i1;
  }

  @Override
  public void show() {
    System.out.println("getI() = " + getI());
    System.out.println("i = " + i);
  }
}