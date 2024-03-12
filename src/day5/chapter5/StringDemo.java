package day5.chapter5;

public class StringDemo {
  public static void main(String[] args) {
    String s1 = "안녕 자바";
    String s2 = "안녕 자바";
    String s3 = new String("안녕 자바");
    String s4 = new String("안녕 자바");

    System.out.println(s1 == s2);
    System.out.println(s1 == s3);
    System.out.println(s2 == s4);
    System.out.println(s3 == s4);
    s1 = s3;
    System.out.println(s3 == s1);

    String s5 = "java";
    String s6 = "JAVA";

    System.out.println(s5.equals(s6));

    System.out.println(s5.equalsIgnoreCase(s6));
    System.out.println(s5.compareToIgnoreCase(s6));
    System.out.println(s5.compareTo(s6));

    s6 = s6.toLowerCase();
    System.out.println(s6);

    String s7 = "Hello, Java";

    System.out.println(s7.subSequence(5, 9));
    System.out.println(s7.substring(5, 9));
    System.out.println(s7.trim());

    String s8 = String.format("%s %s %d", "Hello", "Java", 11);
    System.out.println(s8);

    String s9 = String.join(", ", "aaa", "bbb", "ccc");
    System.out.println(s9);

    String html = """
        <html>
          <body>
          </body>
        </html>
        """;
    System.out.println(html);
  }
}