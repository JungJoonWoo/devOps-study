package day9.chapter7.Ex5;

import java.util.Arrays;
import java.util.Comparator;

public class BookMain {
  public static void main(String[] args) {
    Book[] books = {new Book(15000), new Book(50000), new Book(20000)};

    Arrays.stream(books).forEach(System.out::print);

    Book[] b = Arrays.stream(books)
        .sorted(Comparator.comparingInt(Book::getPrice))
        .toArray(Book[]::new);

    for (Book o : b) {
      System.out.print(o.toString());
    }
  }
}