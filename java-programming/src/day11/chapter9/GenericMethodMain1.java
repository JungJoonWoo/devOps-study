package day11.chapter9;

public class GenericMethodMain1 {
  static class Utils {
    public static <T> void showArray(T[] a) {
      for (T i : a) {
        System.out.println("i = " + i);
      }
    }

    public static <T> T getLast(T[] a) {
      return a[a.length - 1];
    }

    public static <T extends Number> void showArrays(T[] a) {

    }
  }

  public static void main(String[] args) {
    Integer[] i = {1, 2, 3, 4, 5, 6};
    Character[] c = {'a', 'b', 'v'};
    Integer last = Utils.getLast(i);
    System.out.println("last = " + last);
  }
}