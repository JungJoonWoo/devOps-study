package day9.chapter7.Ex3;

public class LineMain {
  public static void main(String[] args) {
    Line l1 = new Line(20);
    Line l2 = new Line(60);

    if (l1.compareTo(l2) == 1) {
      System.out.printf(l1.toString());
    } else if (l1.compareTo(l2) == -1) {
      System.out.printf(l2.toString());
    } else if (l1.compareTo(l2) == 0) {
      System.out.printf("Line[length = %d] 의 길이가 같습니다.", l1.getLine());
    } else {
      System.out.println("잘못된 값임");
    }
  }
}