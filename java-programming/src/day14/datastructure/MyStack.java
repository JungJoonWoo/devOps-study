package day14.datastructure;

import java.util.EmptyStackException;

public class MyStack<E> {

  private int size;
  private Node<E> top;

  public MyStack() {
    this.size = 0;
    this.top = null;
  }

  public E peek() {
    if (!isEmpty())
      return top.getItem();

    throw new EmptyStackException();
  }

  public int size() {
    return size;
  }

  //push
  public void push(E i) {
    Node<E> newNode = new Node<>(i, null);
    newNode.setNext(top);
    top = newNode;
    size++;
  }

  //pop
  public E pop() {
    Node<E> tempNode = top;
    top = top.getNext();
    size--;
    return tempNode.getItem();
  }


  public boolean isEmpty() {
    return size == 0;
  }
}