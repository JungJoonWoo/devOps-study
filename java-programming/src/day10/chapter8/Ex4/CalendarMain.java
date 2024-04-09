package day10.chapter8.Ex4;


import java.util.Calendar;

public class CalendarMain {
  public static void main(String[] args) {
    Calendar c = Calendar.getInstance();
    System.out.println((c.getTime()));
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH) + 1;
    int day = c.get(Calendar.DATE);
    int i = c.get(Calendar.DAY_OF_WEEK);
    int hour = c.get(Calendar.HOUR);
    int min = c.get(Calendar.MINUTE);
    int sec = c.get(Calendar.SECOND);

    System.out.printf("%d년 %d월 %d일\n%d시 %d분 %d초", year,month,day,hour,min,sec);
  }
}