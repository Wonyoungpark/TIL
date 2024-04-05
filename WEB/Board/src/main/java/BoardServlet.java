import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet()
public class BoardServlet extends HttpServlet {
    public BoardServlet() {
        System.out.println("Board Servlet constructor called");
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("BoardServlet init call");

        ServletContext application = config.getServletContext();

        application.getAttribute("boardList");

    }

}
