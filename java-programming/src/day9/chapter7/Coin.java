package day9.chapter7;

public interface Coin {
  int PENNY = 1, NICKEL = 5, DIME = 10, QUARTER = 25;
}

class Coin1Main implements Coin {
  public static void main(String[] args) {
    System.out.printf("Dime은 %d센트 입니다.", Coin.DIME);
  }
}

class Coin2Main implements Coin {
  public static void main(String[] args) {
    System.out.printf("Quarter는 %d센트 입니다.", QUARTER);
  }
}