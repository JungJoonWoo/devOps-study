package day17.libraryminiproject;

import java.util.Date;

public class Checkout {
  private int id;
  private int libId;
  private int bookId;
  private int userId;
  private Date checkoutDate;
  private Date tobeReturnDate;
  private boolean renew;
  private Date renewReturnDate;
  private Date checkinDate;
  private String bookName;
  private String userName;

  public String getBookName() {
    return bookName;
  }

  public String getUserName() {
    return userName;
  }

  public Checkout(int id, int libId, int bookId, int userId, Date checkoutDate, Date tobeReturnDate, String userName, String bookName, Date renewReturnDate, boolean renew) {
    this.id = id;
    this.libId = libId;
    this.bookId = bookId;
    this.userId = userId;
    this.checkoutDate = checkoutDate;
    this.tobeReturnDate = tobeReturnDate;
    this.userName = userName;
    this.bookName = bookName;
    this.renewReturnDate = renewReturnDate;
  }
  public Checkout(int libId, int bookId, int userId, Date checkoutDate, Date tobeReturnDate, String userName, String bookName) {
    this.libId = libId;
    this.bookId = bookId;
    this.userId = userId;
    this.checkoutDate = checkoutDate;
    this.tobeReturnDate = tobeReturnDate;
    this.userName = userName;
    this.bookName = bookName;
  }


  public int getId() {
    return id;
  }

  public int getLibId() {
    return libId;
  }

  public int getBookId() {
    return bookId;
  }

  public int getUserId() {
    return userId;
  }

  public java.sql.Date getCheckoutDate() {
    return (java.sql.Date) checkoutDate;
  }

  public java.sql.Date getTobeReturnDate() {
    return (java.sql.Date) tobeReturnDate;
  }

  public boolean isRenew() {
    return renew;
  }

  public java.sql.Date getRenewReturnDate() {
    return (java.sql.Date) renewReturnDate;
  }

  public java.sql.Date getCheckinDate() {
    return (java.sql.Date) checkinDate;
  }

  @Override
  public String toString() {
    return "Checkout{" +
        "id=" + id +
        ", libId=" + libId +
        ", bookId=" + bookId +
        ", userId=" + userId +
        ", checkoutDate=" + checkoutDate +
        ", tobeReturnDate=" + tobeReturnDate +
        ", renew=" + renew +
        ", renewReturnDate=" + renewReturnDate +
        ", checkinDate=" + checkinDate +
        ", bookName='" + bookName + '\'' +
        ", userName='" + userName + '\'' +
        '}';
  }
}