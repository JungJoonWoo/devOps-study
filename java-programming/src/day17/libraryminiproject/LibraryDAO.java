package day17.libraryminiproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class LibraryDAO {
  Connection conn = DBConnection.getConnection();

  public List<Library> LibraryList() throws SQLException {
    String sql = "select * from libraries;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet resultSet = ps.executeQuery();
    List<Library> libraryList = createLibraryList(resultSet);
    if (libraryList.isEmpty()) {
      System.err.println("*** 도서관 데이터가 없음 ***");
      return null;
    }
    return libraryList;
  }

  //  int libraryCreate(Connection conn, Library library) {
//
//  }
//
//  void libraryUpdate(Connection conn, Library library, LibraryUpdate librayUpdate) {
//
//  }
//
//  void libraryDelete(Connection conn, Library library) {
//
//  }

  public boolean isExistLibraryID(int id) throws SQLException {
    List<Library> libraryList = LibraryList();
    return libraryList.stream().anyMatch(l -> l.getId() == id);
  }
  private List<Library> createLibraryList(ResultSet resultSet) throws SQLException {
    List<Library> libraryList = new LinkedList<>();
    while (resultSet.next()) {
      libraryList.add(new Library(
          resultSet.getInt("id"),
          resultSet.getString("name"),
          resultSet.getString("address"),
          resultSet.getString("telno"),
          resultSet.getString("info")
      ));
    }
    return libraryList;
  }
}