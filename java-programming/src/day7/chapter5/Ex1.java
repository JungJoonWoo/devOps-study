package day7.chapter5;

public class Ex1 {
  public static void main(String[] args) {
    System.out.println(countChar("HElLO", 'L'));
  }

  static int countChar(String s, char c) {
    c = Character.toLowerCase(c);
    s = s.toLowerCase();
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == c) {
        count++;
      }
    }
    return count;

  }
}