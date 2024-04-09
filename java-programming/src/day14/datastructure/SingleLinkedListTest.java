package day14.datastructure;

import java.util.Collections;
import java.util.LinkedList;

public class SingleLinkedListTest {

  public static void main(String[] args) {

    SingleLinkedList<Integer> s1 = new SingleLinkedList<>();
    s1.add(10);
    s1.add(20);
    s1.add(30);
    s1.add(40);
    s1.addFirst(8);
    s1.addFirst(5);
    s1.add(50);

    for (int i = 0; i < s1.size(); i++) {
      System.out.println("s1.get(i) = " + s1.get(i));
    }

    for (int i = 0; i < s1.size();) {
      System.out.println("s1.remove(i) = " + s1.remove(0));
    }
    SingleLinkedList<String> ss = new SingleLinkedList<>();
    ss.add("aaa");
    ss.add("bbb");
    ss.add("ccc");
    ss.add("ddd");
    for (int i = 0; i < ss.size(); i++) {
      System.out.println("ss.get(i) = " + ss.get(i));
    }

    for (int i = 0; i < ss.size();) {
      System.out.println("ss.remove(i) = " + ss.remove(0));
    }

  }

}