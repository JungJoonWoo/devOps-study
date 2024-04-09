package day13.chapter12;

public class MatchMain {
  public static void main(String[] args) {

    if (Nation.nations.stream().allMatch(n -> n.getPopulation() > 100.0)) {
      System.out.println("모든 국가의 인구가 1억이 넘는다.");
    } else {
      System.out.println("모든 국가의 인구가 1억이 넘지 않는다.");
    }

    Nation.nations.stream().filter(Nation::isIsland).forEach(System.out::println);
  }
}