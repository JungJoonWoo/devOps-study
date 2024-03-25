package day15.chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileMain {
  public static void main(String[] args) {
    String input = "C:\\Users\\happy\\OneDrive - 아주대학교\\바탕 화면\\kosta\\temp\\org.txt";
    String output = "C:\\Users\\happy\\OneDrive - 아주대학교\\바탕 화면\\kosta\\temp\\target.txt";
    int read;
    try {
      FileInputStream fis = new FileInputStream(input);
      FileOutputStream fos = new FileOutputStream(output);
      while ((read = fis.read()) != -1) {
        fos.write(read);
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}