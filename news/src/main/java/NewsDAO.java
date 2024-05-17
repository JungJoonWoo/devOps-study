import org.apache.commons.beanutils.BeanUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class NewsDAO {
  final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  final String JDBC_URL = "jdbc:mysql://localhost:3306/news-article-manage?serverTimezone=Asia/Seoul";
  PreparedStatement ps;
  Connection conn;

  public void open() {
    try {
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(JDBC_URL, "root", "1111");
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      conn = null; // If connection failed, set conn to null
    }
  }

  public void close() {
    if (ps != null) { // Check if psmt is not null before closing
      try {
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    if (conn != null) { // Check if conn is not null before closing
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }


  public void addNews(News n) throws SQLException {

    open();
    String sql = "insert into news(title, img, date, content) values(?, ?, ?, ?)";
    ps = conn.prepareStatement(sql);
    ps.setString(1, n.getTitle());
    ps.setString(2, n.getImg());
    ps.setDate(3, Date.valueOf(LocalDate.now()));
    ps.setString(4, n.getContent());
    ps.executeUpdate();
    close();
  }

  public void deleteNews(String id) throws SQLException {
    open();

    String sql = "delete from news where aid = ?";
    ps = conn.prepareStatement(sql);
    ps.setString(1, id);
    ps.executeUpdate();

    close();

  }

  public List<News> findAll() throws SQLException {
    open();
//    date_format(date, '%Y-%m-%d %h-%m-%s') as cdate
    String sql = "select aid,title,date from news";
    ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    List<News> news = new ArrayList<>();
    while (rs.next()) {
      News n = new News();
      n.setAid(rs.getInt("aid"));
      n.setTitle(rs.getString("title"));
      n.setDate(rs.getDate("date"));
      news.add(n);
    }
    close();
    return news;
  }

  public News getNews(int aid) throws SQLException {
    open();
    String sql = "select * from news where aid = ?";
    ps = conn.prepareStatement(sql);
    ps.setInt(1, aid);
    ResultSet rs = ps.executeQuery();
    News n = null;
    while (rs.next()) {
      n = News.builder()
          .aid(rs.getInt("aid"))
          .title(rs.getString("title"))
          .img(rs.getString("img"))
          .date(rs.getDate("date"))
          .content(rs.getString("content"))
          .build();
    }
    close();

    return n;
  }

}
