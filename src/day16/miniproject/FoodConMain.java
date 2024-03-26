package day16.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class FoodConMain {
  static final int DEFAULT_VALUE = 2000;

  public static void main(String[] args) throws SQLException {
    Connection conn = DBConnection.getConnection();
    Scanner sc = new Scanner(System.in);
    System.out.print("1. 식당, 2. 수강생 : ");
    int menu = sc.nextInt();
    sc.nextLine();
    switch (menu) {
      case 1 -> restManage(sc, conn); // 식당 추가 수정
      case 2 -> studentManage(sc, conn); //학생 추가 수정
    }
  }

  private static void studentManage(Scanner sc, Connection conn) throws SQLException {
    System.out.print("1. 추가, 2. 수정 ");
    int submenu = sc.nextInt();
    sc.nextLine();
    switch (submenu) {
      case 1 -> insertStudent(sc, conn);
      case 2 -> updateStudent(sc, conn);
    }
  }

  //계좌 잔액 수정
  private static void updateStudent(Scanner sc, Connection conn) throws SQLException {
    //이름을 입력 받고 수정 가능한지 확인
    String sql = "select * from students where name=?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    System.out.print("변경할 학생의 이름을 입력하세요. ");
    String name = sc.nextLine();
    ps.setString(1, name);
    ResultSet resultSet = ps.executeQuery();
    if (resultSet.next() && resultSet.getDate("date").toLocalDate().equals(LocalDate.now())) {
      System.out.print("1.시간만 변경, 2. 이름과 시간 모두 변경: ");
      int i = sc.nextInt();
      sc.nextLine();
      if (i == 1) {
        System.out.print("변경된 시간을 입력하세요 ");
        sql = "update students set amount=? where name=? ;";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, checkAmount(sc.nextInt()));
        sc.nextLine();
        ps.setString(2, name);
      } else if (i == 2) {
        System.out.print("변경할 이름과 시간을 입력하세요 ");
        String[] s = sc.nextLine().split("[ ,\n\t]");
        //시간을 입력받고 값을 입력
        sql = "update students set name=?, amount=? where name=? ;";
        ps = conn.prepareStatement(sql);
        ps.setString(1, s[0]);
        ps.setInt(2, checkAmount(Integer.parseInt(s[1])));
        ps.setString(3, name);
      }
      if (ps.executeUpdate() == 1) {
        System.out.println("학생 정보 수정 성공");
      } else {
        System.err.println("학생 정보 수정 실패");
      }
    } else {
      System.err.println("존재 하지 않는 학생이거나 당일 발급 받은 식권이 아닙니다.");
    }
  }

  private static int checkAmount(int hour) {
    return hour * DEFAULT_VALUE;
  }

  private static void insertStudent(Scanner sc, Connection conn) throws SQLException {
    System.out.println("학생 정보 추가");
    String sql = "insert into students (name, amount, date) values (?, ?, ?);";
    PreparedStatement ps = conn.prepareStatement(sql);
    System.out.print("학생 이름과 수업시간을 입력하세요: ");
    String[] s = sc.nextLine().split("[ ,\n\t]");
    ps.setString(1, s[0]);
    ps.setInt(2, checkAmount(Integer.parseInt(s[1])));
    ps.setString(3, LocalDate.now().toString());
    if (ps.executeUpdate() == 1) {
      System.out.println("학생 정보 추가 성공");
    } else {
      System.err.println("학생 정보 추가 실패");
    }
  }

  private static void restManage(Scanner sc, Connection conn) throws SQLException {
    System.out.print("1. 추가, 2. 수정 : ");
    int submenu = sc.nextInt();
    sc.nextLine();
    switch (submenu) {
      case 1 -> insertRestaurant(sc, conn);
      case 2 -> updateRestaurant(sc, conn);
    }
  }

  private static void updateRestaurant(Scanner sc, Connection conn) throws SQLException {
    System.out.println("식당 정보 수정");
    String sql = "UPDATE restaurants SET name=? WHERE id=?;";
    System.out.print("수정할 식당의 id와 수정할 이름을 입력하세요. ");
    PreparedStatement ps = conn.prepareStatement(sql);
    String[] s = sc.nextLine().split(" ");
    ps.setInt(2, Integer.parseInt(s[0]));
    ps.setString(1, s[1]);
    if (ps.executeUpdate() == 1) {
      System.out.println("식당 정보 수정 성공");
    } else {
      System.err.println("식당 정보 수정 실패");
    }
  }

  private static void insertRestaurant(Scanner sc, Connection conn) throws SQLException {
    System.out.println("식당 정보 추가");
    String sql = "insert into restaurants (name) values (?);";
    PreparedStatement ps = conn.prepareStatement(sql);
    System.out.print("식당 이름을 작성하시오: ");
    ps.setString(1, sc.nextLine());
    if (ps.executeUpdate() == 1) {
      System.out.println("식당 정보 추가 성공");
    } else {
      System.err.println("식당 정보 추가 실패");
    }
  }
}