package ex0404.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/initTest", loadOnStartup = 1,
        initParams = {
                @WebInitParam(name = "fileName", value = "test.txt"),
                @WebInitParam(name = "contextPath", value = "/servletTest")
        }
)
public class TestInitServlet extends HttpServlet {
    private String fileName,contextPath;

    public TestInitServlet() {
        System.out.println("TestInitServlet Constructor call");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("TestInitServlet init call");

        fileName = config.getInitParameter("fileName");
        contextPath = config.getInitParameter("contextPath");
        System.out.println("fileName = "+fileName);
        System.out.println("contextPath = "+contextPath);

//         context-param 가져오기
        ServletContext application = config.getServletContext();
        String message = application.getInitParameter("message");
        String name = application.getInitParameter("name");
        System.out.println("message = "+message);
        System.out.println("name = "+name);

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestInitServlet service call");
    }
}
