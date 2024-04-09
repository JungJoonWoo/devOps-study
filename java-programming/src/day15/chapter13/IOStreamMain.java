package day15.chapter13;

import java.io.IOException;

public class IOStreamMain {
  public static void main(String[] args) throws IOException {
    System.out.println("---입력 스트림---");

    int[] readByte = new int[100];
    int read = System.in.read();
    int len = 0;

    System.out.println();
    System.out.println("---출력 스트림---");

    while (!(read == '\n')) {
      System.out.printf("%c(%d), ", (char) read, len);
      readByte[len++] = read;
      read = System.in.read();
    }
    System.out.println();

    System.out.flush();
  }


}