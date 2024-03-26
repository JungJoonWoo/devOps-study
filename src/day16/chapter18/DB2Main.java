package day16.chapter18;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DB2Main {
  public static void main(String[] args) throws SQLException {
    //1. DB연결
    Connection conn = DBConnection.makeConnection();

    //2. sql작성
    String sql = "delete from mytable where id = ?;";

    //3. statememt 객체 생성 -> set 메서드를 이용해 변수 값 설정
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, 3);

    //4. statement 객체, executeQuery 나 executeUpdate 를 이용해 데이터 조작
    if (ps.executeUpdate() == 1) {
      System.out.println("삭제 성공");
    } else {
      System.err.println("삭제 실패");
    }
  }

}