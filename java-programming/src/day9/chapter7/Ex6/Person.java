package day9.chapter7.Ex6;

public class Person {
  private String name;
  private int age;
  private int height;
  private int weight;

  public Person(String name, int age, int height, int weight) {
    this.name = name;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int getHeight() {
    return height;
  }

  @Override
  public String toString() {
    return "PersonMain[" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", height=" + height +
        ", weight=" + weight +
        ']';
  }


  public int getWeight() {
    return weight;
  }
}