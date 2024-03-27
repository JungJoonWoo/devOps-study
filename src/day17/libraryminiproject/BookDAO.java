package day17.libraryminiproject;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;


public class BookDAO {

  Connection conn = DBConnection.getConnection();

  public void bookUpdate(Book book, String status) throws SQLException {
    String sql = "UPDATE books SET status=? WHERE bookname=? and isbn=?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, status);
    ps.setString(2, book.getBookname());
    ps.setString(3, book.getIsbn());

    if (ps.executeUpdate() == 1) {
      System.out.println("***도서 수정 성공***");
    } else {
      System.err.println("도서 수정 실패");
    }
  }

  public boolean isBreakBook(Book book) {
    if (book.getStatus().equals("파손")) {
      return true;
    }
    return false;
  }
  //존재하는지 확인 후 객체 반환
  public Book bookCheck(int libId, String bookname) throws SQLException {
    List<Book> bookList = bookList();
    List<Book> collect = bookList.stream().filter(book -> book.getBookname().equals(bookname) && book.getLibId() == libId).collect(Collectors.toList());
    return collect.getFirst();
  }

  public void bookDelete(Book book) throws SQLException {
    String sql = "Delete From books where bookname=? and isbn=?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, book.getBookname());
    ps.setString(2, book.getIsbn());
    if (ps.executeUpdate() == 1) {
      System.out.println("성공적으로 삭제 성공");
    } else {
      System.err.println("도서 삭제 실패");
    }
  }
  private static List<Book> createBookList(ResultSet resultSet) throws SQLException {
    List<Book> bookList = new LinkedList<>();
    while (resultSet.next()) {
      bookList.add(new Book(
          resultSet.getInt("id"),
          resultSet.getInt("lib_id"),
          resultSet.getString("bookname"),
          resultSet.getString("writername"),
          resultSet.getString("publisher"),
          resultSet.getString("bookclass"),
          resultSet.getString("isbn"),
          resultSet.getString("kubun"),
          resultSet.getString("status")
      ));
    }
    return bookList;
  }

  //CRUD
  //전체 조회
  public List<Book> bookList() throws SQLException {
    String sql = "select * from books;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet resultSet = ps.executeQuery();
    List<Book> bookList = createBookList(resultSet);
    if (bookList.isEmpty()) {
      System.err.println("*** 책 데이터가 없음 ***");
      return null;
    }
    return bookList;
  }

  //책 이름으로 조회
  public List<Book> bookListByName(String bookname) throws SQLException {
    String sql = "select * from books where bookname=?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, bookname);
    ResultSet resultSet = ps.executeQuery();
    List<Book> bookList = createBookList(resultSet);
    if (bookList.isEmpty()) {
      System.err.print("\n*** 책 데이터가 없음 ***\n다시 선택하세요: ");
      return null;
    }
    return bookList;
  }

  //작가명으로 조회
  public List<Book> bookListByWriter(String writer) throws SQLException {
    String sql = "select * from books where writername=?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, writer);
    ResultSet resultSet = ps.executeQuery();
    List<Book> bookList = createBookList(resultSet);
    if (bookList.isEmpty()) {
      System.err.print("\n*** 책 데이터가 없음 ***\n다시 선택하세요: ");
      return null;
    }
    return bookList;
  }

  //출판사로 조회
  public List<Book> bookListByPublisher(String publisher) throws SQLException {
    String sql = "select * from books where publisher=?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, publisher);
    ResultSet resultSet = ps.executeQuery();
    List<Book> bookList = createBookList(resultSet);
    if (bookList.isEmpty()) {
      System.err.print("\n*** 책 데이터가 없음 ***\n다시 선택하세요: ");
      return null;
    }
    return bookList;
  }

  public Book bookInfo() throws SQLException {
    Scanner sc = new Scanner(System.in);
    System.out.printf("도서관 ID를 입력하세요: ");
    int libId = sc.nextInt();
    sc.nextLine();
    LibraryDAO libraryDAO = new LibraryDAO();
    if (!libraryDAO.isExistLibraryID(libId)) {
      System.err.println("존재하지 않는 도서관 입니다. ");
      return null;
    }
    System.out.printf("도서명을 입력하세요: ");
    String bookname = sc.nextLine();
    System.out.printf("작가명을 입력하세요: ");
    String writername = sc.nextLine();
    System.out.printf("출판사를 입력하세요: ");
    String publisher = sc.nextLine();
    System.out.printf("도서 분류(3글자)를 입력하세요: ");
    String bookClass = sc.nextLine();
    String isbn = UUID.randomUUID().toString().replace("-", "").substring(0, 13);
    System.out.printf("구매인지 기증인지 입력하세요: ");
    String kubun = sc.nextLine();
//    System.out.printf("대출 여부를 입력하세여: ");
    String status = "대출가능";
    return new Book(libId, bookname, writername, publisher, bookClass, isbn, kubun, status);

  }

  public Integer bookCreate(Book book) throws SQLException {
    String sql = "insert into books (lib_id, bookname, writername, publisher, bookClass, isbn, kubun, status) values (?,?,?,?,?,?,?,?);";
    PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1, book.getLibId());
    ps.setString(2, book.getBookname());
    ps.setString(3, book.getWritername());
    ps.setString(4, book.getPublisher());
    ps.setString(5, book.getBookClass());
    ps.setString(6, book.getIsbn());
    ps.setString(7, book.getKubun());
    ps.setString(8, book.getStatus());

    if (ps.executeUpdate() == 1) {
      ResultSet generatedKeys = ps.getGeneratedKeys();
      if (generatedKeys.next()) {
        int i = generatedKeys.getInt(1);
        System.out.println("생성된 책의 ID: " + i);
        return i;
      }
    }

    System.err.println("도서 정보 추가에 실패");
    return null;
  }
}