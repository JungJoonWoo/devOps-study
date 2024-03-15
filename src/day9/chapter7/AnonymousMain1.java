package day9.chapter7;

public class AnonymousMain1{
  private class Eagle implements Bird {
    @Override
    public void move() {
      System.out.println("Eagle.move");
    }
  }

  Eagle e = new Eagle();
  public static void main(String[] args) {
    AnonymousMain1 a = new AnonymousMain1();
    a.e.move();
  }
}