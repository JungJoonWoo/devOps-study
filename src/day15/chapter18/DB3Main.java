package day15.chapter18;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static day15.chapter18.DB2Main.*;

public class DB3Main {
  public static void main(String[] args) throws SQLException {

    Connection conn = makeConnection();
    Statement st = conn.createStatement();
    String sql = "SELECT name,age from mytable;";
    ResultSet rs = st.executeQuery(sql);
    while (rs.next()) {
      System.out.print("rs.getString(\"name\") = " + rs.getString("name") + "\t");
      System.out.println("rs.getString(\"age\") = " + rs.getString("age"));
    }
  }
}