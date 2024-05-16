package ch05;


public class Calculator {
  private int n1;

  public int getN1() {
    return n1;
  }

  public void setN1(int n1) {
    this.n1 = n1;
  }

  public int getN2() {
    return n2;
  }

  public void setN2(int n2) {
    this.n2 = n2;
  }

  public String getOp() {
    return op;
  }

  public void setOp(String op) {
    this.op = op;
  }

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
