package day9.chapter7.Ex1;

public abstract class AbstractTest {
  private int i;

  public AbstractTest(int i) {
    this.i = i;
  }

  public int getI() {
    return i;
  }

  public abstract void show();
}