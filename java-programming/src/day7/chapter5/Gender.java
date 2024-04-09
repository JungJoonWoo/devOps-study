package day7.chapter5;

enum Gender {
  MALE("남성"), FEMALE("여성");

  private String s;

  Gender(String s) {
    this.s = s;
  }

  @Override
  public String toString() {
    return s;
  }
}