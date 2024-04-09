package day16.chapter18;

import java.sql.*;

public class DBMain {
  public static void main(String[] args) throws SQLException {
    Connection conn = makeConnection();
    String sql = "update mytable set age= ? where id=?";
    PreparedStatement ps = conn.prepareStatement(sql);

    ps.setInt(1,40);
    ps.setInt(2, 2);

    if (ps.executeUpdate() == 1) {
      System.out.println("수정 성공");
    } else {
      System.err.println("수정 실패");

    }
    conn.close();
    ps.close();

  }

  public static Connection makeConnection() {
    String url = "jdbc:mysql://localhost/mydata?serverTimezone=Asia/Seoul";
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