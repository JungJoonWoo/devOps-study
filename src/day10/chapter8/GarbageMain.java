package day10.chapter8;

public class GarbageMain {
  public static void main(String[] args) {
    for (int i = 0; i <3 ; i++) {
      Garbage g = new Garbage(i);
      System.gc();
//      g.finalize();
    }
  }
}

class Garbage {
  private int no;

  public Garbage(int no) {
    this.no = no;
  }

  @Override
  protected void finalize(){
    System.out.printf("Garbage{%d} 작동\n", no);
  }
}