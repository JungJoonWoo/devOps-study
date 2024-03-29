package day16.DBminiproject;

public class Student {
  private int id;
  private String date;
  private String name;
  private int amount;

  public Student(int id, String date, String name, int amount) {
    this.id = id;
    this.date = date;
    this.name = name;
    this.amount = amount;
  }

  public int getId() {
    return id;
  }

  public String getDate() {
    return date;
  }

  public String getName() {
    return name;
  }

  public int getAmount() {
    return amount;
  }

}