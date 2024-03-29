package day10.chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringTokenizerMain {
  public static void main(String[] args) throws IOException {

    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(r.readLine());

    while (st.hasMoreTokens()) {
      System.out.println(st.nextToken());
    }
  }
}