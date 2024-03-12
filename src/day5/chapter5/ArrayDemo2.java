package day5.chapter5;

import java.io.IOException;
import java.util.Scanner;

public class ArrayDemo2 {
  public static void main(String[] args) throws IOException {
//    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
//
//    StringTokenizer st = new StringTokenizer(r.readLine());
//    int sum = 0;
//    int avg = 0;
//    int i = 0;
//    int m = st.countTokens();
//    for (i = 0; i < m; i++) {
//      int n = Integer.parseInt(st.nextToken());
//      sum += n;
//    }
//    avg = sum / i;
//    w.write(sum + " " + avg);
//
//    w.close();
//    r.close();
//
    int[] scores = new int[5];
    Scanner sc = new Scanner(System.in);
    int sum = 0;
    int avg = 0;
    for (int i = 0; i < 5; i++) {
      scores[i] = sc.nextInt();
      sum += scores[i];
    }
    avg = sum / 5;
    System.out.println(sum);
    System.out.println(avg);
  }
}