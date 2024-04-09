package day9.chapter7.Ex8;

import java.util.Arrays;

public class ControllerMain {
  public static void main(String[] args) {
    Controller[] c = {
        new Tv(false),
        new Radio(true)
    };

    Arrays.stream(c).forEach(Controller::show);
  }
}

//for-loop vs stream
//io Scanner vs BufferedReader