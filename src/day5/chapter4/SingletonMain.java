package day5.chapter4;

public class SingletonMain {
  public static void main(String[] args) {
    Singleton s1 = Singleton.getInstance();
    Singleton s2 = Singleton.getInstance();

    System.out.println(s1);
    System.out.println(s2);
  }
}