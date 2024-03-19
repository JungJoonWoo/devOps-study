package day11.chapter10;

import java.util.Arrays;

public class GenericMethodMain2 {
  public static void main(String[] args) {
    Ticket[] tickets = {
        new Ticket(234),
        new Ticket(10),
        new Ticket(7),
        new Ticket(1),
        new Ticket(5),
        new Ticket(4),
    };
    long count = Arrays.stream(tickets).
        filter(t -> t.getNum() > tickets[tickets.length - 1].getNum())
        .count();
    System.out.println("count = " + count);
  }


}

class Ticket {
  private int num;

  public Ticket(int num) {
    this.num = num;
  }

  public int getNum() {
    return num;
  }
}