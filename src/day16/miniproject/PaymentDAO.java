package day16.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class PaymentDAO {
  public static void insertPayment(Scanner sc, Connection conn) throws SQLException {

    System.out.print("학생 이름, 식당 이름, 가격을 입력하세요. : ");
    String[] s = sc.nextLine().split("[ ,\t\n]");
    if (Integer.parseInt(s[2]) < 0) {
      System.err.println("잘못된 값이 입력됨");
      return;
    }
    ResultSet resultSetStudent = StudentDAO.checkName(sc, conn, s[0]);
    ResultSet resultSetRestaurant = RestaurantDAO.checkRestaurant(sc, conn, s[1]);

    if (resultSetStudent.next() && resultSetRestaurant.next()) {
      String sql = "insert into payment (rid, sid, date, payment) values(?, ?, ?, ?);";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, Integer.parseInt(resultSetRestaurant.getString("id")));
      ps.setInt(2, Integer.parseInt(resultSetStudent.getString("id")));
      ps.setString(3, LocalDate.now().toString());
      int balance = resultSetStudent.getInt("amount") - Integer.parseInt(s[2]);
      if (balance < 0) {
        System.err.println("잔액보다 비쌈");
        return;
      }
      ps.setInt(4, Integer.parseInt(s[2]));
      if (!StudentDAO.updateAmount(s[0], balance, conn)) {
        System.err.println("잔액이 정상적으로 변경되지 않음");
      }

      if (ps.executeUpdate() == 1) {
        System.out.println("결제 테이블 정보 추가 성공");
      } else {
        System.err.println("결제 테이블 정보 추가 실패");
      }
    } else {
      System.err.println("학생 이름 혹은 가게 이름이 잘못되었습니다.");
    }
  }
}