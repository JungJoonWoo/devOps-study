package day10.chapter8;

public class GenericClassMain {
  public static void main(String[] args) {
    Cup<Beer> c1 = new Cup<>();
    c1.setBeverage(new Beer());
    c1.getBeverage().drink();

    Cup<Boricha> c2 = new Cup<>();
    c2.setBeverage(new Boricha());
    c2.getBeverage().drink();
  }
}

class Beverage {
  void drink() {
    System.out.println("Beverage.drink");
  }
}

class Boricha extends Beverage {
  @Override
  void drink() {
    System.out.println("Boricha.drink");
  }
}

class Beer extends Beverage {
  @Override
  void drink() {
    System.out.println("Beer.drink");
  }
}

class Cup<T> {

  private T beverage;

  public T getBeverage() {
    return beverage;
  }

  public void setBeverage(T beverage) {
    this.beverage = beverage;
  }
}