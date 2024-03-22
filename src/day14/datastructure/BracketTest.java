package day14.datastructure;

import java.util.Stack;

public class BracketTest<E> {
  public static void main(String[] args) {
    String[] p = {"{", "(", ")", "}"};
    Stack<String> bracket = new Stack<>();

    for (String s : p) {
      if (s.equals("(") || s.equals("{")) {
        bracket.push(s);
      } else if (s.equals(")")) {
        if (bracket.isEmpty() || !bracket.pop().equals("(")) {
          System.out.println("괄호가 맞지않음");
          return;
        }

      } else if (s.equals("}")) {
        if (bracket.isEmpty() || !bracket.pop().equals("{")) {
          System.out.println("괄호가 맞지않음");
          return;
        }
      }
    }
    if (!bracket.isEmpty()) {
      System.out.println("괄호가 맞지않음");
      return;
    }
    System.out.println("정상");

  }
}