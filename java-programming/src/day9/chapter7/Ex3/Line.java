package day9.chapter7.Ex3;

public class Line implements Comparable{
  private int line;

  public Line(int line) {
    this.line = line;
  }

  public int getLine() {
    return line;
  }

  @Override
  public int compareTo(Object o) {
    if (o instanceof Line l){
      if (line - l.getLine() > 0) {
        return 1;
      } else if (line - l.getLine() < 0) {
        return -1;
      } else if (line - l.getLine() == 0) {
        return 0;
      }
    }
      return 2;


  }

  @Override
  public String toString() {
    return "Line[length = " + getLine() + "]";
  }
}