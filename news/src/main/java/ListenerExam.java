import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ListenerExam implements ServletContextListener, ServletContextAttributeListener,
    HttpSessionListener, HttpSessionAttributeListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    sce.getServletContext().log("ServleContext가 시작됨");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    sce.getServletContext().log("ServleContext가 종료됨");
  }

  @Override
  public void attributeAdded(ServletContextAttributeEvent event) {
    event.getServletContext().log("속성 추가됨: " + event.getName() + " : " + event.getValue());
  }
}
