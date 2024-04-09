package day15.chapter13;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileMain1 {
  public static void main(String[] args) {
    String input = "C:\\Users\\happy\\OneDrive - 아주대학교\\바탕 화면\\kosta\\temp\\org.txt";
    String output = "C:\\Users\\happy\\OneDrive - 아주대학교\\바탕 화면\\kosta\\temp\\target1.txt";
    int read;

    try {
      FileReader fis = new FileReader(input);
      FileWriter fos = new FileWriter(output, true);
      while ((read = fis.read()) != -1) {
        fos.write(read);
      }
      fos.flush();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}