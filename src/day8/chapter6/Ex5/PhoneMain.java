package day8.chapter6.Ex5;

import java.util.Arrays;

public class PhoneMain {
  public static void main(String[] args) {
    Phone[] phones = {new Phone("황진이"), new Telephone("길동이", "내일"), new Smartphone("만국이", "갤러그")};

    Arrays.stream(phones).forEach((phone -> {
      if (phone instanceof Smartphone s) {
        s.playGame();
      } else if (phone instanceof Telephone t) {
        t.autoAnswering();
      } else if (phone instanceof Phone p) {
        p.talk();
      }
    }));
  }
}