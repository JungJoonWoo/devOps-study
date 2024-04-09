package day9.chapter7.Ex5;

public class Book {
  private int price;

  public Book(int price) {
    this.price = price;
  }

  public int getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return String.format("Book[price = %d]\n", getPrice());
  }
}