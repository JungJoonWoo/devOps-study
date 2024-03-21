package day13.chapter12;

public class FlatMapMain {
  public static void main(String[] args) {

    Nation.nations.stream()
        .map(Nation::getName)
        .limit(4L).forEach(Util::print);

    System.out.println();

    Nation.nations.stream()
        .map(Nation::getGdpRank)
        .forEach(Util::print);
  }
}