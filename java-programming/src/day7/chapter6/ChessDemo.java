package day7.chapter6;

public class ChessDemo {


  public static void main(String[] args) {
    ChessPlayer cp = new ChessPlayer();
    cp.startRule();
  }
}
enum ChessColor {
  BLACK, WHITE
}
class Chess {
  final ChessColor startColor = ChessColor.WHITE;
}

class ChessPlayer extends Chess {
  void startRule() {
    System.out.println("startColor = " + startColor);
  }
}