package day13.chapter13;

import java.util.ArrayList;

public class ArrListTest {
  public static void main(String[] args) {
//    ArrayList<Integer> al = new ArrayList<>();
//    al.add(10);
//    al.add(20);
//
//    System.out.println(al.get(0));
//
//    System.out.println(al.remove(0) + " 삭제됨");

    ArrList<Integer> ar = new ArrList<>();
    ar.add(10);
    ar.add(20);
    ar.add(30);

    ar.removeLast();
  }
}