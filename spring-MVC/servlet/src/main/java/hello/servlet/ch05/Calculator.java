package hello.springstart.ch05;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Calculator {
  private int n1;
  private int n2;
  private String op;

  public long calc() {
    long result = 0;
    switch (op) {
      case "+":
        result = n1 + n2;
        break;
      case "-":
        result = n1 - n2;
        break;
      case "*":
        result = (long) n1 * n2;
        break;
      case "/":
        if (n2 != 0) {
            result = n1 / n2;
        } else {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        break;
    }
    return result;
}

}
