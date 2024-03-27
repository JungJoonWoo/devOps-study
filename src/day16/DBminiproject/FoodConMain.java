package day16.DBminiproject;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static day16.DBminiproject.PaymentDAO.insertPayment;
import static day16.DBminiproject.RestaurantDAO.insertRestaurant;
import static day16.DBminiproject.RestaurantDAO.updateRestaurant;
import static day16.DBminiproject.StudentDAO.insertStudent;
import static day16.DBminiproject.StudentDAO.updateStudent;

public class FoodConMain {

  public static void main(String[] args) throws SQLException {
    Connection conn = DBConnection.getConnection();
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.print("1. 식당, 2. 수강생, 3. 결제, -1. 종료 : ");
      int menu = sc.nextInt();
      sc.nextLine();
      if (menu == -1) {
        System.out.println("종료");
        break;
      }
      switch (menu) {
        case 1 -> restManage(sc, conn); // 식당 추가 수정
        case 2 -> studentManage(sc, conn); //학생 추가 수정
        case 3 -> paymentManage(sc, conn);
      }
    }
  }

  private static void paymentManage(Scanner sc, Connection conn) throws SQLException {
    System.out.println("결제 정보 추가");
    insertPayment(sc, conn);
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

  private static void restManage(Scanner sc, Connection conn) throws SQLException {
    System.out.print("1. 추가, 2. 수정 : ");
    int submenu = sc.nextInt();
    sc.nextLine();
    switch (submenu) {
      case 1 -> insertRestaurant(sc, conn);
      case 2 -> updateRestaurant(sc, conn);
    }
  }

}