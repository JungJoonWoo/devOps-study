package day13.chapter12;

public class SortedMain {
   public static void main(String[] args) {

     Nation.nations.stream()
         .sorted((o1, o2) -> o2.getGdpRank() - o1.getGdpRank())
         .map(nation -> nation.getName() + ": " + nation.getGdpRank()).forEach(Util::print);

     System.out.println("\n");

     Nation.nations.stream()
         .sorted((o1, o2) -> (int) (o1.getPopulation() - o2.getPopulation()))
         .map(nation -> nation.getName() + ": " + nation.getPopulation()).forEach(Util::print);
  }
}