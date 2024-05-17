import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/news.nhn")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2, location = "C:\\temp\\img")
public class NewsController extends HttpServlet {

  private NewsDAO newsDAO;
  private ServletContext ctx;

  @Override
  public void init() throws ServletException {
    super.init();
    newsDAO = new NewsDAO();
    ctx = getServletContext();
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
//    init();
    String action = request.getParameter("action");
    String START_PAGE = "/NewsList.jsp";
    if (action == null) {
      ctx.getRequestDispatcher("/NewsList.jsp").forward(request, response);
    } else {
      try {
        if (action.equals("list")) {
          request.setAttribute("news", newsDAO.findAll());
          ctx.getRequestDispatcher("/NewsList.jsp").forward(request, response);
        } else if (action.equals("showNewsDetail")) {
          request.setAttribute("news", newsDAO.getNews(Integer.parseInt(request.getParameter("aid"))));
          ctx.getRequestDispatcher("/NewsDetail.jsp").forward(request, response);
        } else if (action.equals("addNews")) {
          Part part = request.getPart("img");
          log(part.toString());
          String fileName = part.getSubmittedFileName();
          log(fileName);

          // 지정된 경로에 디렉토리가 없다면 생성
          String uploadPath = "C:\\temp\\img";
          File uploadDir = new File(uploadPath);
          if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // mkdirs를 사용하여 중간 경로도 함께 생성
          }

          // 파일 저장 경로 생성
          String filePath = uploadPath + File.separator + fileName;

          // 파일을 지정된 경로에 저장
          part.write(filePath);
          log("File saved at: " + filePath);

          // 파일 경로를 News 객체에 설정 (이 부분은 실제 구현에 맞게 조정 필요)
          News news = new News();
          BeanUtils.populate(news, request.getParameterMap());
          news.setImg(filePath); // 파일 경로를 'img' 속성에 저장

          // DB에 뉴스 추가
          newsDAO.addNews(news);
          log(news.toString());

          ctx.getRequestDispatcher(START_PAGE).forward(request, response);
        }


      } catch (SQLException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        throw new RuntimeException(e);
      } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
