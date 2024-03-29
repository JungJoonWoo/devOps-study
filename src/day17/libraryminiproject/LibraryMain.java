package day17.libraryminiproject;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LibraryMain {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) throws SQLException {
    int input1;
    while (true) {
      System.out.print("1. 도서 서비스, 2. 사용자 서비스, 2. 도서관 서비스, 4. 대출 서비스, 5. 종료: ");
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


  private static void checkoutService() throws SQLException {
    System.out.println("***대출 서비스 실행***");
    System.out.print("1. 대출중인 도서 조회, 2. 도서 대출, 3. 도서 반납, 4. 반납 기한 연장, 5. 처음으로 가기: ");
    int input2 = sc.nextInt();
    sc.nextLine();
    switch (input2) {
      case 1 -> lookupCheckoutService();
      case 2 -> enrollCheckoutService();
//      case 3 -> modifyUserService();
//      case 4 -> deleteUserService();
      case 5 -> {
        return;
      }

    }
  }

  private static void enrollCheckoutService() throws SQLException {
    CheckoutDAO checkoutDAO = new CheckoutDAO();
    System.out.println("***대출 등록 실행***");
    Checkout checkout = checkoutDAO.checkoutInfo();
    if (user == null || userDAO.userCreate(user) == null) {
      System.err.println("***사용자 등록에 실패***\n다시 입력하세요: ");
    } else {
      System.out.println("사용자 정보 추가 성공");
    }
  }

  private static void lookupCheckoutService() throws SQLException {
    CheckoutDAO checkoutDAO = new CheckoutDAO();
    System.out.print("1. 전체 조회, 2. 도서명으로 조회, 3. 사용자 이름, 비밀번호로 조회, 4. 사용자 회원번호, 비밀번호로 조회, 5. 처음으로 가기: ");
    int input = sc.nextInt();
    sc.nextLine();
    switch (input) {
      case 1 -> {
        List<Checkout> checkoutList = checkoutDAO.checkoutList();
        printCheckoutList(checkoutList);
      }
      case 2 -> {
        System.out.print("***도서명으로 조회***\n도서명을 입력하세요: ");
        List<Object> objects = checkoutDAO.checkoutListByBookName(sc.nextLine());
        if (objects == null) {
          System.err.println("***대출 실패***");
          return;
        }
        System.out.println(objects.getFirst());
        System.out.println(objects.getLast());

      }
      case 3 -> {
        System.out.print("***사용자 이름과 비밀번호로 조회***\n사용자의 이름과 비밀번호를 입력하세요: ");
        String[] s = sc.nextLine().split("[ ,.\n\t]");
        List<Object> objects = checkoutDAO.checkoutListByUserNameAndPassword(s[0], s[1]);

        if (objects == null) {
          System.err.println("***일치하는 사용자 정보가 없음***");
          return;
        } else if (objects.isEmpty()) {
          return;
        }
        User user = (User) objects.getFirst();
        System.out.println(user);
        List<Checkout> checkoutList = (List<Checkout>) objects.getLast();
        checkoutList.stream().forEach(System.out::println);
      }
      case 4 -> {
        System.out.print("***사용자 Id와 비밀번호로 조회***\n사용자의 Id과 비밀번호를 입력하세요: ");
        String[] s = sc.nextLine().split("[ ,.\n\t]");
        List<Object> objects = checkoutDAO.checkoutListByUserIdAndPassword(Integer.parseInt(s[0]), s[1]);

        if (objects == null) {
          System.err.println("***일치하는 사용자 정보가 없음***");
          return;
        } else if (objects.isEmpty()) {
          return;
        }
        User user = (User) objects.getFirst();
        System.out.println(user);
        List<Checkout> checkoutList = (List<Checkout>) objects.getLast();
        checkoutList.stream().forEach(System.out::println);
      }
      case 5 -> {
        return;
      }
    }
  }


  private static void userService() throws SQLException {
    System.out.println("***사용자 서비스 실행***");
    System.out.print("1. 사용자 조회, 2. 사용자 등록, 3. 사용자 수정, 4. 사용자 삭제, 5. 처음으로 가기: ");
    int input2 = sc.nextInt();
    sc.nextLine();
    switch (input2) {
      case 1 -> lookupUserService();
      case 2 -> enrollUserService();
      case 3 -> modifyUserService();
      case 4 -> deleteUserService();
      case 5 -> {
        return;
      }

    }
  }

  private static void deleteUserService() throws SQLException {
    UserDAO userDAO = new UserDAO();
    System.out.println("***사용자 정보 삭제 실행(대출중인 책이 없는 사용자만 삭제 가능)***");
    System.out.print("삭제할 사용자의 이름과 비밀번호 입력하세요: ");
    String[] s = sc.nextLine().split("[ ,\n\t]");
    //대출 DAO 작성 후 대출중인 책의 이름과 사용자의 이름이 같은지 확인한 후 같다면 대출 불가로 처리
    //    try{
//      User user = userDAO.userCheckByUsernameAndPassword(s[0], s[1]);
//
//    }catch ()

  }

  private static void modifyUserService() throws SQLException {

  }

  private static void lookupUserService() throws SQLException {
    UserDAO userDAO = new UserDAO();
    System.out.print("1. 전체 조회, 2. 사용자명으로 조회, 3. 사용자 회원번호로 조회, 4. 처음으로 가기: ");
    int input = sc.nextInt();
    sc.nextLine();
    switch (input) {
      case 1 -> {
        List<User> userList = userDAO.userList();
        printUserList(userList);
      }
      case 2 -> {
        System.out.print("***사용자명으로 조회***\n사용자명을 입력하세요: ");
        List<User> userList = userDAO.userListByName(sc.nextLine());
        printUserList(userList);
      }
      case 3 -> {
        System.out.print("***사용자 회원번호로 조회***\n사용자의 회원번호를 입력하세요: ");
        User user = userDAO.userByID(sc.nextInt());
        sc.nextLine();
        if (user == null) {
          System.err.println("***존재하지 않는 사용자***");
          return;
        }
        System.out.println(user);
      }
      case 4 -> {
        return;
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
      case 2 -> enrollBookService();
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

//  private static User checkExistUserPassword(UserDAO userDAO, String password) throws SQLException {
//    Book book = bookDAO.bookCheck(libId, bookname);
//    if (book == null) {
//      System.err.println("존재하지 않는 책입니다.");
//      return null;
//    }
//    return book;
//  }


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

  private static void enrollUserService() throws SQLException {
    UserDAO userDAO = new UserDAO();
    System.out.println("***사용자 등록 실행***");
    User user = userDAO.userInfo();
    if (user == null || userDAO.userCreate(user) == null) {
      System.err.println("***사용자 등록에 실패***\n다시 입력하세요: ");
    } else {
      System.out.println("사용자 정보 추가 성공");
    }
  }

  private static void enrollBookService() throws SQLException {
    BookDAO bookDAO = new BookDAO();
    System.out.println("***도서 등록 실행***");
    Book book = bookDAO.bookInfo();
    if (book == null || bookDAO.bookCreate(book) == null) {
      System.err.println("***도서 등록에 실패***\n다시 입력하세요: ");
    } else {
      System.out.println("도서 정보 추가 성공");
    }
  }

  /**
   * 도서관에 있는 도서의 리스트를 출력
   *
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


  private static void libraryService() {

  }


  private static void printCheckoutList(List<Checkout> checkoutList) {
    if (checkoutList == null) {
      System.err.println("도서 대출 데이터가 없음");
      return;
    }
    checkoutList.forEach(System.out::println);
  }

  private static void printUserList(List<User> userList) {
    if (userList == null) {
      System.err.println("사용자 데이터가 없음");
      return;
    }
    userList.forEach(System.out::println);
  }

  private static void printBookList(List<Book> bookList) {
    if (bookList == null) {
      return;
    }
    bookList.forEach(System.out::println);
  }
}