package day11.chapter10;

public class Entry<T, V> {
  private T key;
  private V value;

  public Entry(T key, V value) {
    this.key = key;
    this.value = value;
  }

  public T getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }
}