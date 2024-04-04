package ex0404.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet()
public class initParamServlet extends HttpServlet {
    private static final long serialVersionID = 1L;

    public initParamServlet() {
        System.out.println("initParamServlet 생성자 call");
    }

    // 생성자 : 객체 생성
    // init : Servlet에 대한 초기 세팅
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("initParamServlet init call");

        String dbId = config.getInitParameter("dbId");
        String dbPwd = config.getInitParameter("dbPwd");

        System.out.println("dbId = " + dbId);
        System.out.println("dbPwd = " + dbPwd);

        //         context-param 가져오기
        ServletContext application = config.getServletContext();
        String message = application.getInitParameter("message");
        String name = application.getInitParameter("name");

//        다른 servlet에서 전달된 init-param 가져오기 (안됨)
        String fileName = config.getInitParameter("fileName");
        String contextPath = config.getInitParameter("contextPath");
        System.out.println("fileName = " + fileName);
        System.out.println("contextPath = " + contextPath);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("initParamServlet service call");
    }
}
