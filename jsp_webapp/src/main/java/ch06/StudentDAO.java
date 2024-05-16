package ch06;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO {
  final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  final String JDBC_URL = "jdbc:mysql://localhost:3306/webapp?serverTimezone=Asia/Seoul";
  Connection conn;
  PreparedStatement ps;

  public void open() {
    try {
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(JDBC_URL, "root", "1111");
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      conn = null; // If connection failed, set conn to null
    }
  }

  public void close() {
    if (ps != null) { // Check if psmt is not null before closing
      try {
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    if (conn != null) { // Check if conn is not null before closing
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }


  public void insert(Student s) throws SQLException {
    open();
    String sql = "insert into student(username, univ, birth, email) values(?, ?, ?, ?)";
    ps = conn.prepareStatement(sql);
    ps.setString(1, s.getUsername());
    ps.setString(2, s.getUniv());
    ps.setDate(3, s.getBirth());
    ps.setString(4, s.getEmail());
    ps.executeUpdate();
    close();
  }

  public void update(String id, String email) throws SQLException {
    open();

    String sql = "update student set email = ? where id = ?";
    ps = conn.prepareStatement(sql);
    ps.setString(1, email);
    ps.setString(2, id);
    ps.executeUpdate();

    close();

  }

  public List<Student> findAll() throws SQLException {
    open();
    String sql = "select * from student";
    ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    List<Student> students = new ArrayList<>();
    while (rs.next()) {
      Student s = Student.builder()
          .id(rs.getInt("id"))
          .univ(rs.getString("univ"))
          .username(rs.getString("username"))
          .birth(rs.getDate("birth"))
          .email(rs.getString("email")).build();
      students.add(s);
    }
    close();
    return students;
  }
}
