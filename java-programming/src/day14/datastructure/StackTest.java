package day14.datastructure;

public class StackTest {
  public static void main(String[] args) {
    MyStack<Integer> ms = new MyStack<>();
    ms.push(10);
    ms.push(20);
    ms.push(30);

    System.out.println(ms.peek());
    for (int i = 0; i < ms.size();) {
      System.out.println("ms.pop() = " + ms.pop());
    }
  }
}