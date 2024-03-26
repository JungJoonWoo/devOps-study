package day16.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RestaurantDAO {

  public static void updateRestaurant(Scanner sc, Connection conn) throws SQLException {
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

  public static void insertRestaurant(Scanner sc, Connection conn) throws SQLException {
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
  public static ResultSet checkRestaurant(Scanner sc, Connection conn, String name) throws SQLException {
    String sql = "select * from restaurants where name=?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, name);
    return ps.executeQuery();

  }
}