package day13.chapter13;

import java.util.Arrays;

public class ArrList<E> {
  private E[] a;
  private int size;

  public ArrList() {
    a = (E[]) new Object[2]; // 최초로 10개의 원소를 가지느 배열 생성
    size = 0;
  }

  //get, remove, add
  public E get(int index) throws NoSuchFieldException {
    if (size == 0) {
      throw new NoSuchFieldException("size가 0임");
    }
    return a[index];
  }

  public E removeLast() {
    E e = (E) a[size - 1];
    a[size-- - 1] = null;

    if (size > 2 && size <= a.length / 4) {
      resize(a.length/2);
    }

    return e;
  }
  public void add(E v) {
    if (a.length == size) {
      resize(size * 2);
    }
    a[size++] = v;
  }

  private void resize(int size) {
    a = Arrays.copyOf(a, size);
  }

  public int length() {
    return size;
  }

  public int size() {
    return a.length;
  }
}