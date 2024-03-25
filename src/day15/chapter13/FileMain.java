package day15.chapter13;

import java.io.File;
import java.util.Arrays;

public class FileMain {
  public static void main(String[] args) {
    File file = new File("C:\\Users\\happy\\OneDrive - 아주대학교\\바탕 화면\\kosta\\temp");
    File[] files = file.listFiles();
    Arrays.stream(files).forEach(f -> {
      if (f.isDirectory()) {
        System.out.println("dir : " + f);
      } else {
        System.out.println("file : " + f + " - " + f.length() + " bytes");
      }
    });
  }
}