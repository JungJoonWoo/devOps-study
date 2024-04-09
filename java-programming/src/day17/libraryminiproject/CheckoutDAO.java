package day17.libraryminiproject;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CheckoutDAO {
  Connection conn = DBConnection.getConnection();

  private static List<Checkout> createCheckoutList(ResultSet resultSet) throws SQLException {
    List<Checkout> checkoutList = new LinkedList<>();
    while (resultSet.next()) {
      checkoutList.add(new Checkout(
          resultSet.getInt("id"),
          resultSet.getInt("lib_id"),
          resultSet.getInt("book_id"),
          resultSet.getInt("user_id"),
          resultSet.getDate("checkoutdate"),
          resultSet.getDate("tobereturndate"),
          resultSet.getString("username"),
          resultSet.getString("bookname"),
          resultSet.getDate("renewreturn_date"),
          resultSet.getBoolean("renew")));

    }
    return checkoutList;
  }


  List<Checkout> checkoutList() throws SQLException {
    String sql = "select * from checkout;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet resultSet = ps.executeQuery();
    List<Checkout> checkoutList = createCheckoutList(resultSet);
    if (checkoutList.isEmpty()) {
      return null;
    }
    return checkoutList;
  }

  /**
   * 1. 책 이름으로 대출리스트에 있는지 확인
   * 2. 존재한다면 책 정보와 대출 정보 출력
   *
   * @param bookname
   * @return
   */
  List<Object> checkoutListByBookName(String bookname) throws SQLException {
    List<Object> existCheckout = isExistCheckout(bookname);

    if (existCheckout == null) {
      return null;
    }
    return existCheckout;

  }

  //책 이름이랑 책 아이디 비교 후 존재하면 리턴
  private List<Object> isExistCheckout(String bookname) throws SQLException {
    BookDAO bookDAO = new BookDAO();
    List<Book> bookList = bookDAO.bookListByName(bookname);
    if (bookList == null) {
      System.err.println("***대출 실패***");
      System.err.println("존재하지 않는 책");
      return null;
    }
    Book book = bookList.getFirst();
    CheckoutDAO checkoutDAO = new CheckoutDAO();
    List<Checkout> checkoutList = checkoutDAO.checkoutList();
    Checkout checkout = checkoutList.stream().filter(c -> c.getBookId() == book.getId()).toList().getFirst();
    List<Object> l = new ArrayList<>();

    if (checkout == null) {
      System.err.println("***대출 실패***");
      System.err.println("존재하지 않는 책");
      return null;
    }
    l.add(book);
    l.add(checkout);
    return l;
  }
  void renewProcess(Checkout checkout) throws SQLException {
    String sql = "update checkout set renew=?, renewreturn_date=? where id=?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setBoolean(1, true);
    LocalDate renewReturnDate = checkout.getTobeReturnDate().toLocalDate().plusDays(7);
    ps.setDate(2, Date.valueOf(renewReturnDate));
    ps.setInt(3, checkout.getId());
    if (ps.executeUpdate() == 1) {
      System.out.println("대출기한 연장 성공");
      return;
    }
    System.err.println("대출 기한 연장 실패");
  }
//  void renewProcess(Checkout checkout) throws SQLException {
//    String sql = "update checkout set renew=?,renewreturn_date=? where id=?;";
//    PreparedStatement ps = conn.prepareStatement(sql);
//    ps.setBoolean(1, true);
//    LocalDate renewReturnDate = checkout.getTobeReturnDate().toLocalDate().plusDays(7);
//    ps.setDate(2, Date.valueOf(renewReturnDate));
//    ps.setInt(3, checkout.getId());
//    if (ps.executeUpdate() == 1) {
//      System.out.println("대출기한 연장 성공");
//      return;
//    }
//    System.err.println("대출 기한 연장 실패");
//
//  }


  List<Object> checkoutListByUserNameAndPassword(String username, String password) throws SQLException {
    UserDAO userDAO = new UserDAO();
    List<User> userList = userDAO.userList();
    List<Object> objects = new ArrayList<>();
    List<User> lists = userList.stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).toList();
    if (lists.isEmpty()) {
      System.err.println("사용자 이름과 비밀번호가 맞지 않음");
      return null;
    }
    User user = lists.getFirst();
    int userId = user.getId();

    List<Checkout> checkoutList = checkoutList();
    if (checkoutList == null) {
      System.err.println("대출한 도서가 없음");
      return null;
    }
    List<Checkout> checkouts = checkoutList.stream().filter(c -> c.getUserId() == userId).toList();
    if (checkouts.isEmpty()) {
      System.err.println("본 이용자는 대출한 도서가 없음");
    } else {
      objects.add(user);
      objects.add(checkouts);
    }
    return objects;

  }

  List<Object> checkoutListByUserIdAndPassword(int userId, String password) throws SQLException {
    UserDAO userDAO = new UserDAO();
    List<User> userList = userDAO.userList();
    List<Object> objects = new ArrayList<>();
    List<User> lists = userList.stream().filter(u -> (u.getId() == userId) && u.getPassword().equals(password)).toList();
    if (lists.isEmpty()) {
      System.err.println("사용자 이름과 비밀번호가 맞지 않음");
      return null;
    }
    User user = lists.getFirst();

    List<Checkout> checkoutList = checkoutList();

    List<Checkout> checkouts = checkoutList.stream().filter(c -> c.getUserId() == userId).toList();
    if (checkouts.isEmpty()) {
      System.err.println("본 이용자는 대출한 도서가 없음");
    } else {
      objects.add(user);
      objects.add(checkouts);
    }
    return objects;

  }

  //  boolean checkoutCheck()
  public Checkout checkoutInfo() throws SQLException {
    Scanner sc = new Scanner(System.in);
    System.out.print("도서관 ID를 입력하세요: ");
    int libId = sc.nextInt();
    sc.nextLine();
    LibraryDAO libraryDAO = new LibraryDAO();
    if (!libraryDAO.isExistLibraryID(libId)) {
      System.err.println("존재하지 않는 도서관 입니다. ");
      return null;
    }
    BookDAO bookDAO = new BookDAO();

    System.out.print("도서명을 입력하세요: ");
    String bookname = sc.nextLine();
    List<Book> bookList = bookDAO.bookListByName(bookname);
    if (bookList.isEmpty()) {
      System.err.println("도서명 입력 오류");
      return null;
    }
    Book book = bookList.getFirst();
    if (!book.getStatus().equals("대출가능")) {
      System.err.println("대출 가능한 상태가 아닙니다.");
      return null;
    }

    if (!(book.getLibId() == libId)) {
      System.err.println("이 도서관에 없는 책입니다.");
      return null;
    }
    System.out.printf("사용자 이름을 입력하세요: ");
    String username = sc.nextLine();
    UserDAO userDAO = new UserDAO();
    List<User> userList = userDAO.userListByName(username);
    if (userList.isEmpty()) {
      System.err.println("잘못된 사용자 입니다.");
      return null;
    }
    List<Checkout> checkoutList = checkoutList();
    User user = userList.getFirst();
    long count = 0;
    if (checkoutList !=null) {
      count = checkoutList.stream().filter(c -> c.getUserId() == user.getId()).count();
    }
    if (count >= 5) {
      System.err.println("최대 대여 가능 갯수는 5개 입니다.");
      return null;
    }
    Date checkoutDate = Date.valueOf(LocalDate.now());
    Date toBeReturnDate = Date.valueOf(LocalDate.now().plusDays(14));
    bookDAO.bookUpdate(book, "대출중");
    return new Checkout(libId, book.getId(), user.getId(), checkoutDate, toBeReturnDate, username, bookname);
  }


  public Integer checkoutCreate(Checkout checkout) throws SQLException {
    String sql = "insert into checkout (lib_id, book_id, user_id, checkoutdate, tobereturndate, username, bookname, id, renewreturn_date, checkin_date) values (?,?,?,?,?,?,?,?, ?,?);";
    PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1, checkout.getLibId());
    ps.setInt(2, checkout.getBookId());
    ps.setInt(3, checkout.getUserId());
    ps.setDate(4, checkout.getCheckoutDate());
    ps.setDate(5, checkout.getTobeReturnDate());
    ps.setString(6, checkout.getUserName());
    ps.setString(7, checkout.getBookName());
    ps.setInt(8, checkout.getId());
    ps.setDate(9, checkout.getTobeReturnDate());
    ps.setDate(10, checkout.getCheckinDate());
    if (ps.executeUpdate() == 1) {
      ResultSet generatedKeys = ps.getGeneratedKeys();
      if (generatedKeys.next()) {
        int i = generatedKeys.getInt(1);
        System.out.println("생성된 책의 ID: " + i);
        return i;
      }
    }
    System.err.println("대출 정보 추가에 실패");
    return null;
  }

  boolean checkinProcess(Checkout checkout) throws SQLException {
    String sql = "update checkout set checkin_date=? where id=?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setDate(1, Date.valueOf(LocalDate.now()));
    ps.setInt(2, checkout.getId());
    if (ps.executeUpdate() == 1) {
      System.out.println("반납 완료");
      return true;
    }
    System.err.println("반납 실패");
    return false;
  }

  public void setCheckinDate(Checkout checkout) throws SQLException {
    String sql = "update checkout set renew=? where id=?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setBoolean(1,true);

    ps.setInt(2, checkout.getId());
    if (ps.executeUpdate() == 1) {
      System.out.println("반납 날짜 등록 성공");
      return;
    }
    System.err.println("반납 날짜 등록 실패");
  }
}
//
//  List<Checkout> checkoutListByUserId(Connection conn, String userId) {
//  }
//
//
//  Checkout checkoutInfo(Connection conn, Checkout checkout) {
//
//  }
//
//  boolean checkoutCheck(Connection conn, Book book, Checkout checkout) {
//
//  }
//
//  void checkoutProcess(Connection conn, Checkout checkout) {
//
//  }
//
//  boolean checkoutCheck(Connection conn, Book book, Checkout checkout) {
//
//  }
//

//
//  boolean checkoutCheck(Connection conn, Book book, Checkout checkout) {
//
//  }
//
//  void renewProcess(Connection conn, User user, Checkout checkout) {
//
//  }