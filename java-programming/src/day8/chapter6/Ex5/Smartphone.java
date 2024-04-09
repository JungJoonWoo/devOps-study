package day8.chapter6.Ex5;

public class Smartphone extends Telephone {
  private String game;

  public Smartphone(String owner, String game) {
    super(owner, "");
    this.game = game;
  }

  public String getGame() {
    return game;
  }

  public void playGame() {
    System.out.println(getOwner() + "가 " + getGame()+" 게임 중");
  }
}