package ex0328.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class LifecycleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LifecycleServlet() {
        System.out.println("LifecycleServlet의 생성자 호출");
    }

    public void init(ServletConfig config) throws ServletException{
        System.out.println("LifecycleServlet service call");
    }

    public void destroy(){
        System.out.println("LifecycleServlet의 destroy call");
    }

    /*
    사용자 요청이 들어오면 service() 호출
    원래 service() 기능은 사용자의 요청 방식에 따라 doGet/doPost를 호출
    but, service를 재정의하면, 기존 기능이 아닌 재정의 기능을 동작
     */
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
//        System.out.println("LifecycleServlet의 service call");
//    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("LifecycleServlet의 doGet call");
//        브라우저에 출력
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<head><title>Servlet Practice</title></head>");
        out.print("<body>");

        out.print("<h1 style='color:red'>Servlet 실습</h1>");

        out.print("<script>");
        out.print("alert('스크립트 테스트');");
        out.print("</script>");

        out.print("</body>");
        out.print("</html>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LifecycleServlet의 doPost call");
    }
}
