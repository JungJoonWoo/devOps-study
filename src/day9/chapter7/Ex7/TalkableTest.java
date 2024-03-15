package day9.chapter7.Ex7;

public class TalkableTest {

  public static void main(String[] args) {

    TalkableTest t = new TalkableTest();
    speak(new Korean());
    speak(new American());

  }

  static void speak(Talkable talkable) {

    talkable.talk();

  }
}