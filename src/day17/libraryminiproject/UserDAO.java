package day17.libraryminiproject;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UserDAO {

  Connection conn = DBConnection.getConnection();

  private static List<User> createUserList(ResultSet resultSet) throws SQLException {
    List<User> userList = new LinkedList<>();
    while (resultSet.next()) {
      userList.add(new User(
          resultSet.getInt("id"),
          resultSet.getInt("lib_id"),
          resultSet.getString("username"),
          resultSet.getString("telno"),
          resultSet.getString("address"),
          resultSet.getInt("point"),
          resultSet.getString("password")
      ));
    }
    return userList;
  }

  List<User> userList() throws SQLException {
    String sql = "select * from users;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet resultSet = ps.executeQuery();
    List<User> userList = createUserList(resultSet);
    if (userList.isEmpty()) {
      System.err.println("*** 유저 데이터가 없음 ***");
      return null;
    }
    return userList;
  }

  List<User> userListByName(String username) throws SQLException {
    String sql = "select * from users where username=?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, username);
    ResultSet resultSet = ps.executeQuery();
    List<User> userList = createUserList(resultSet);
    if (userList.isEmpty()) {
      System.err.print("\n*** 책 데이터가 없음 ***\n다시 선택하세요: ");
      return null;
    }
    return userList;
  }

  User userByID(int userid) throws SQLException {
    String sql = "select * from users where id=?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, userid);
    ResultSet resultSet = ps.executeQuery();
    List<User> userList = createUserList(resultSet);
    if (userList.isEmpty()) {
      System.err.print("\n*** 유저 데이터가 없음 ***\n다시 선택하세요: ");
      return null;
    }
    return userList.getFirst();
  }


  User userInfo() throws SQLException {
    Scanner sc = new Scanner(System.in);
    System.out.printf("도서관 ID를 입력하세요: ");
    int libId = sc.nextInt();
    sc.nextLine();
    LibraryDAO libraryDAO = new LibraryDAO();
    if (!libraryDAO.isExistLibraryID(libId)) {
      System.err.println("존재하지 않는 도서관 입니다. ");
      return null;
    }
    System.out.printf("사용자 이름을 입력하세요: ");
    String username = sc.nextLine();
    System.out.printf("전화번호를 입력하세요: ");
    String telno = sc.nextLine();
    if (!userTelnoDuplicateCheck(telno)) {
      System.err.println("***이미 존재하는 전화번호***");
      return null;
    }
    System.out.printf("주소를 입력하세요: ");
    String address = sc.nextLine();
    System.out.printf("비밀번호를 입력하세요: ");
    int point = 0;
    String password = sc.nextLine();
    return new User(libId, username, telno, address, point, password);
  }

  //비밀번호 일치 시 주소, 연락처 수정 가능
  void userUpdateByPasswordToAddress(User user, String address) throws SQLException {
    String sql = "UPDATE users SET address=? WHERE password=?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, address);
    ps.setString(2, user.getPassword());

    if (ps.executeUpdate() == 1) {
      System.out.println("***사용자 비밀번호 수정 성공***");
    } else {
      System.err.println("사용자 비밀번호 수정 실패");
    }
  }
  void userUpdateByPasswordToTelno(User user, String telno) throws SQLException {
    String sql = "UPDATE users SET telno=? WHERE password=?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, telno);
    ps.setString(2, user.getPassword());

    if (ps.executeUpdate() == 1) {
      System.out.println("***사용자 비밀번호 수정 성공***");
    } else {
      System.err.println("사용자 비밀번호 수정 실패");
    }
  }

  void userUpdateByTelno(User user, String address, String telno) throws SQLException {
    String sql = "UPDATE users SET address=?,telno=? WHERE password=?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, address);
    ps.setString(2, telno);
    ps.setString(3, user.getPassword());

    if (ps.executeUpdate() == 1) {
      System.out.println("***사용자 주소, 연락처 수정 성공***");
    } else {
      System.err.println("사용자 주소, 연락처 수정 실패");
    }
  }

  public User userCheckByPassword(String password) throws SQLException {
    List<User> userList = userList();
    List<User> collect = userList.stream().filter(user -> user.getPassword().equals(password)).toList();
    return collect.getFirst();
  }

  public User userCheckByTelno(String telno) throws SQLException {
    List<User> userList = userList();
    List<User> collect = userList.stream().filter(user -> user.getTelno().equals(telno)).toList();
    return collect.getFirst();
  }
  public User userCheckByUsernameAndPassword(String username, String password) throws SQLException {
    List<User> userList = userList();
    List<User> collect = userList.stream().filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password)).toList();
    return collect.getFirst();
  }
//
//  boolean userCheck(User user) {
//
//  }
//
//  void userDelete(User user) {
//
//  }
//
//  Library libraryInfo(Scanner in) {
//
//  }

  private boolean userTelnoDuplicateCheck(String telno) throws SQLException {
    String sql = "Select telno from users where telno=?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, telno);
    ResultSet resultSet = ps.executeQuery();
    if (resultSet.next()) {
      System.err.println("이미 존재하는 isbn입니다.");
      return false;
    }
    return true;
  }


  public Integer userCreate(User user) throws SQLException {
    String sql = "insert into users (lib_id, username, telno, address, point, password) values (?,?,?,?,?,?);";
    PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1, user.getLibId());
    ps.setString(2, user.getUsername());
    ps.setString(3, user.getTelno());
    ps.setString(4, user.getAddress());
    ps.setInt(5, user.getPoint());
    ps.setString(6, user.getAddress());

    if (ps.executeUpdate() == 1) {
      ResultSet generatedKeys = ps.getGeneratedKeys();
      if (generatedKeys.next()) {
        int i = generatedKeys.getInt(1);
        System.out.println("생성된 사용자의 ID: " + i);
        return i;
      }
    }

    System.err.println("사용자 정보 추가에 실패");
    return null;
  }


}