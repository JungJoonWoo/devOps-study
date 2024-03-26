package day16.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class StudentDAO {
  static final int AMOUNT_PER_HOUR = 2000;

  public static void updateStudent(Scanner sc, Connection conn) throws SQLException {
    //이름을 입력 받고 수정 가능한지 확인
    System.out.print("변경할 학생의 이름을 입력하세요. ");
    String name = sc.nextLine();
    ResultSet resultSet = checkName(sc, conn, name);
    if (resultSet.next() && resultSet.getDate("date").toLocalDate().equals(LocalDate.now())) {
      System.out.print("1.시간만 변경, 2. 이름과 시간 모두 변경: ");
      int i = sc.nextInt();
      sc.nextLine();

      if (i == 1) {
        System.out.print("변경된 시간을 입력하세요 ");
        if (updateAmount(name, checkAmount(sc.nextInt()), conn)) {
          System.out.println("학생 정보 수정 성공");
        } else {
          System.err.println("학생 정보 수정 실패");
        }
        sc.nextLine();
      } else if (i == 2) {
        System.out.print("변경할 이름과 시간을 입력하세요 ");
        String[] s = sc.nextLine().split("[ ,\n\t]");
        //시간을 입력받고 값을 입력
        if (updateAmount(name, checkAmount(Integer.parseInt(s[1])), conn) && updateName(conn, s[0], name)) {
          System.out.println("학생 정보 수정 성공");
        }else {
          System.err.println("학생 정보 수정 실패");
        }
      }
    } else {
      System.err.println("존재 하지 않는 학생이거나 당일 발급 받은 식권이 아닙니다.");
    }
  }

  private static boolean updateName(Connection conn, String newName, String name) throws SQLException {
    PreparedStatement ps;
    String sql;
    sql = "update students set name=? where name=? ;";
    ps = conn.prepareStatement(sql);
    ps.setString(1, newName);
    ps.setString(2, name);
    if (ps.executeUpdate() == 1) {
      return true;
    }
    return false;
  }


  private static int checkAmount(int hour) {
    return hour * AMOUNT_PER_HOUR;
  }

  public static void insertStudent(Scanner sc, Connection conn) throws SQLException {
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

  public static ResultSet checkName(Scanner sc, Connection conn, String name) throws SQLException {
    String sql = "select * from students where name=?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, name);
    return ps.executeQuery();

  }

  public static boolean updateAmount(String name, int value, Connection conn) throws SQLException {
    String sql = "update students set amount=? where name=? ;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, value);
    ps.setString(2, name);
    if (ps.executeUpdate() == 1) {
      return true;
    }
    return false;
  }
}