package day17.libraryminiproject;

import java.sql.*;
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
          resultSet.getBoolean("renew"),
          resultSet.getDate("renewreturn_date"),
          resultSet.getDate("checkin_date")
      ));
    }
    return checkoutList;
  }

  List<Checkout> checkoutList() throws SQLException {
    String sql = "select * from checkout;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet resultSet = ps.executeQuery();
    List<Checkout> checkoutList = createCheckoutList(resultSet);
    if (checkoutList.isEmpty()) {
      System.err.println("*** 책 데이터가 없음 ***");
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

  public Checkout checkoutInfo() throws SQLException {
    Scanner sc = new Scanner(System.in);
    System.out.printf("도서관 ID를 입력하세요: ");
    int libId = sc.nextInt();
    sc.nextLine();
    LibraryDAO libraryDAO = new LibraryDAO();
    if (!libraryDAO.isExistLibraryID(libId)) {
      System.err.println("존재하지 않는 도서관 입니다. ");
      return null;
    }
    return null;

//    System.out.printf("도서명을 입력하세요: ");
//    String bookname = sc.nextLine();
//    System.out.printf("작가명을 입력하세요: ");
//    String writername = sc.nextLine();
//    System.out.printf("출판사를 입력하세요: ");
//    String publisher = sc.nextLine();
//    System.out.printf("도서 분류(3글자)를 입력하세요: ");
//    String bookClass = sc.nextLine();
//    String isbn = UUID.randomUUID().toString().replace("-", "").substring(0, 13);
//    if(isbnDuplicateCheck(isbn)){
//      return null;
//    }
//    System.out.printf("구매인지 기증인지 입력하세요: ");
//    String kubun = sc.nextLine();
//    String status = "대출가능";
//    return new Book(libId, bookname, writername, publisher, bookClass, isbn, kubun, status);

  }

  public Integer checkoutCreate(Checkout checkout) throws SQLException {
    String sql = "insert into checkout (lib_id, book_id, user_id, checkoutdate, tobereturndate) values (?,?,?,?,?);";
    PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1, checkout.getLibId());
    ps.setInt(2, checkout.getBookId());
    ps.setInt(3, checkout.getUserId());
    ps.setDate(4, checkout.getCheckoutDate());
    ps.setDate(5, checkout.getTobeReturnDate());

    if (ps.executeUpdate() == 1) {
      ResultSet generatedKeys = ps.getGeneratedKeys();
      if (generatedKeys.next()) {
        int i = generatedKeys.getInt(1);
        System.out.println("생성된 책의 ID: " + i);
        return i;
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
//  void checkinProcess(Connection conn, User user, Checkout checkout) {
//
//  }
//
//  boolean checkoutCheck(Connection conn, Book book, Checkout checkout) {
//
//  }
//
//  void renewProcess(Connection conn, User user, Checkout checkout) {
//
//  }
  }