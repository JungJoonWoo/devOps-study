package day14.datastructure;


public class SingleLinkedList<E> {

  private Node<E> head;
  private int size;
  private Node<E> tail;

  public SingleLinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  //탐색, 삽입, 삭제
  public int size() {
    return size;
  }

  public void add(E value) {
    Node<E> newNode = new Node<>(value, null);
    if (size == 0) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    size++;
  }

  public void addFirst(E value) {
    Node<E> newNode = new Node<>(value, null);
    if (size == 0) {
      head = tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
    size++;
  }

  public E peek() {
    return tail.getItem();
  }

  public E showFirst() {
    return head.getItem();
  }

  public E get(int index) {
    return getNode(index).getItem();
  }

  public E getFirst() {
    return getNode(0).getItem();
  }

  public E getLast() {
    return getNode(size - 1).getItem();
  }

  public Node<E> getNode(int index) {
    if (size - 1 < index) {
      throw new IndexOutOfBoundsException();
    }
    Node<E> nextNode = head;
    for (int i = 0; i < index; i++) {
      nextNode = nextNode.next;
    }
    return nextNode;
  }

  public E remove(int index) {
    if (size - 1 < index) {
      throw new IndexOutOfBoundsException();
    }
    E deleteDate;
    if (index == 0) {
      deleteDate = head.getItem();
      head = head.next;
    }
    else {
      Node<E> tempNode = getNode(index - 1);
      deleteDate = tempNode.next.getItem();
      tempNode.next = tempNode.next.next;
    }
    size--;
    return deleteDate;
  }
}

class Node<E> {
  Node<E> next;
  private E item;

  public Node(E item, Node<E> node) {
    this.item = item;
    this.next = node;
  }

  E getItem() {
    return item;
  }

  Node getNext() {
    return next;
  }

  public void setNext(Node<E> next) {
    this.next = next;
  }
}