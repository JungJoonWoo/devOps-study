package day13.chapter12.Ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemberMain {
  public static void main(String[] args) {
    List<Member> list = Arrays.asList(new Member("홍길동", "개발자"), new Member("김나리", "디자이너"), new Member("신용권", "개발자"));
    list.stream().filter(m -> m.getJob().equals("개발자")).forEach(m -> System.out.println(m.getName()));
  }
}