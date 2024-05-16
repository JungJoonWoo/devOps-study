package ch06;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/studentControl")
public class StudentController extends HttpServlet {
  StudentDAO studentDAO;

  public StudentController() {
    studentDAO = new StudentDAO();
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String action = request.getParameter("action");
    String view = "";

    if (action == null) {
      // 처리 방법에 따라 다르지만, 여기서는 예외를 던지도록 하겠습니다.
      throw new IllegalArgumentException("Action parameter is required.");
    } else {
      try {
        switch (action) {
          case "list":
            view = list(request, response);
            getServletContext().getRequestDispatcher("/ch06/" + view).forward(request, response);
            break;
          case "insert":
            insert(request, response);
            response.sendRedirect("studentControl?action=list");
            break;
          case "updateGet":
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("id", id);
            getServletContext().getRequestDispatcher("/ch06/StudentUpdate.jsp").forward(request, response);
            break;

          case "updatePost":
            update(request, response);
            response.sendRedirect("studentControl?action=list");
            break;
          default:
            throw new IllegalStateException("Unexpected value: " + action);
        }
      } catch (SQLException | InvocationTargetException | IllegalAccessException e) {
        e.printStackTrace();
      }
    }

  }

  private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException {
    try {
      studentDAO.update(request.getParameter("id"), request.getParameter("email"));
    } catch (SQLException e) {
      e.printStackTrace();
      throw new ServletException("Database update error", e);
    }
  }

  private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, InvocationTargetException, IllegalAccessException {
    Student s = new Student();
    BeanUtils.populate(s, request.getParameterMap());
    studentDAO.insert(s);
//    return list(request, response);
  }

  private String list(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    request.setAttribute("students", studentDAO.findAll());
    return "StudentInfo.jsp";
  }

}
