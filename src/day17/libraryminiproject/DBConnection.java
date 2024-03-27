package day17.libraryminiproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

  private static final Connection conn = DBConnection.createConnection();

  public static Connection getConnection(){
    return conn;
  }

  private static Connection createConnection() {
    String url = "jdbc:mysql://localhost/library?serverTimezone=Asia/Seoul";
    Connection conn = null;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("데이터 베이스 연결중 ...");

      conn = DriverManager.getConnection(url, "root", "1111");
      System.out.println("데이터 베이스 연결 성공!!!");
    } catch (ClassNotFoundException e) {
      System.err.println("JDBC 드라이버를 찾지 못했습니다");

    } catch (SQLException e) {
      System.err.println("데이터 베이스 연결 실패 ...");

    }
    return conn;
  }

}