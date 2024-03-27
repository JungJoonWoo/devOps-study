package day17.libraryminiproject;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LibraryMain {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) throws SQLException {
    int input1;
    while (true) {
      System.out.printf("1. 도서 서비스, 2. 사용자 서비스, 2. 도서관 서비스, 4. 대출 서비스, 5. 종료: " );
      input1 = sc.nextInt();
      sc.nextLine();
      if (input1 == -1) {
        break;
      }
      switch (input1) {
        case 1 -> bookService();
        case 2 -> userService();
        case 3 -> libraryService();
        case 4 -> checkoutService();
        case 5 -> {
          return;
        }
      }
    }
  }

  private static void bookService() throws SQLException {
    System.out.println("***도서 서비스 실행***");
    System.out.print("1. 도서 조회, 2. 도서 등록, 3. 도서 수정, 4. 도서 삭제, 5. 처음으로 가기: ");
    int input2 = sc.nextInt();
    sc.nextLine();
    switch (input2) {
      case 1 -> lookupBookService();
      case 2-> enrollBookService();
      case 3 -> modifyBookService();
      case 4 -> deleteBookService();

    }

  }

  private static void deleteBookService() throws SQLException {
    BookDAO bookDAO = new BookDAO();
    System.out.println("***도서 삭제 실행(파손인 도서만 삭제 가능)***");
    System.out.print("삭제할 도서의 도서관 번호와 이름을 입력하세요: ");
    Book book = checkExistBook(bookDAO);
    if (book == null) {
      System.err.println("도서 삭제 실패");
    } else if (bookDAO.isBreakBook(book)) {
      System.out.println("파손된 도서임을 확인. 도서 삭제 진행");
      bookDAO.bookDelete(book);
    } else {
      System.err.println("파손되지 않은 도서는 삭제할 수 없음");
    }
  }

  private static void modifyBookService() throws SQLException {
    BookDAO bookDAO = new BookDAO();
    System.out.println("***도서 수정 실행(대출 가능 여부만 수정 가능)***");
    System.out.print("수정할 도서의 도서관 번호와 이름을 입력하세요: ");
    Book book = checkExistBook(bookDAO);
    if (book == null) {
      System.err.println("도서 수정 실패");
      return;
    }
    System.out.printf("변경할 상태를 입력하세요(대출 가능, 파손): ");
    bookDAO.bookUpdate(book, sc.nextLine());
  }

  private static Book checkExistBook(BookDAO bookDAO) throws SQLException {
    String[] s = sc.nextLine().split("[ ,\t\n]");
    int libId = Integer.parseInt(s[0]);
    String bookname = s[1];
    Book book = bookDAO.bookCheck(libId, bookname);
    if (book == null) {
      System.err.println("존재하지 않는 책입니다.");
      return null;
    }
    return book;
  }

  private static void enrollBookService() throws SQLException {
    BookDAO bookDAO = new BookDAO();
    System.out.println("***도서 등록 실행***");
    if (bookDAO.bookCreate(bookDAO.bookInfo()) == null) {
      System.err.println("***도서 등록에 실패***\n다시 입력하세요: ");
    } else {
      System.out.println("도서 정보 추가 성공");
    }
  }

  /**
   * 도서관에 있는 도서의 리스트를 출력
   * @throws SQLException
   */
  private static void lookupBookService() throws SQLException {
    BookDAO bookDAO = new BookDAO();
    System.out.print("1. 전체 조회, 2. 도서명으로 조회, 3. 작가명으로 조회, 4. 출판사명으로 조회, 5. 처음으로 가기: ");
    int input = sc.nextInt();
    sc.nextLine();
    switch (input) {
      case 1 -> {
        List<Book> bookList = bookDAO.bookList();
        printBookList(bookList);
      }
      case 2 -> {
        System.out.print("***도서명으로 조회***\n도서명을 입력하세요: ");
        List<Book> bookList = bookDAO.bookListByName(sc.nextLine());
        printBookList(bookList);
      }
      case 3 -> {
        System.out.print("***작가명으로 조회***\n작가명을 입력하세요: ");
        List<Book> bookList = bookDAO.bookListByWriter(sc.nextLine());
        printBookList(bookList);
      }
      case 4 -> {
        System.out.print("***출판사로 조회***\n출판사를 입력하세요: ");
        List<Book> bookList = bookDAO.bookListByPublisher(sc.nextLine());
        printBookList(bookList);
      }
      case 5 -> {
        return;
      }
    }
  }

  private static void userService() {

  }

  private static void libraryService() {

  }

  private static void checkoutService() {

  }

  private static void printBookList(List<Book> bookList) {
    if (bookList == null) {
      return;
    }
    bookList.forEach(System.out::println);
  }
}