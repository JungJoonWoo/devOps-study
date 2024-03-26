package day15.chapter18;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {
  public static void main(String[] args) {
    try {
      Socket client = new Socket("localhost", 5000);
      OutputStream os = client.getOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(os);
      oos.writeObject("Hello, simple server");
      oos.flush();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}