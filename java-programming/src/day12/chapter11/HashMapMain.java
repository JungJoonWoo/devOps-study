package day12.chapter11;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class HashMapMain {
  public static void main(String[] args) {
    Map<Fruit, Integer> map = new HashMap<>();

    map.put(new Fruit("Apple"), 3);
    map.put(new Fruit("Apple"), 20);
    map.put(null, 3);
    map.put(new Fruit(null), 5);
    map.put(new Fruit("banana"), 3);
    System.out.println(map);

    Set<Fruit> fruits = map.keySet();
    System.out.println(fruits);
    Collection<Integer> values = map.values();
    System.out.println(values);
  }
}

class Fruit {
  String name;

  public Fruit(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "name=" + name;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Fruit f) {
      if (name.equals(f.name)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }
}