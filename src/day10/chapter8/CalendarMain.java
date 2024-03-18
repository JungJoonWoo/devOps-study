package day10.chapter8;

import java.util.Calendar;
import java.util.Date;

public class CalendarMain {
  public static void main(String[] args) {
    Date date = new Date();
    System.out.println(date.getTime());

    Calendar calendar = Calendar.getInstance();
    System.out.println(calendar.getTime());
  }
}