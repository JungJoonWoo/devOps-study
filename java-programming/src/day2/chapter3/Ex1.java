package day2.chapter3;

public class Ex1 {
  public static void main(String[] args) {
    int sum = 0;
    for (int i = 1; i <= 100; i++) {
      if (i % 2 == 0) {
        sum += i;
      }
    }
    System.out.println(sum);

    int sum1 = 0;
    for (int i = 0; i <=100 ; i +=2) {
      sum1 += i;
    }
    System.out.println(sum1);
    int sum2 = 0;
    int i = 1;

    while(i <= 100){
      if (i % 2 == 0) {
        sum2 += i;
      }
      i++;
    }
    System.out.println(sum2);
  }

}