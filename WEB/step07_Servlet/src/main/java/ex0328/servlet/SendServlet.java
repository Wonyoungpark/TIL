package ex0328.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class SendServlet extends HttpServlet {
    private static final long serialVersionID = 1L;

    public SendServlet() {
        System.out.println("SendServlet 생성자 call");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SendServlet doGet call");

        String job = request.getParameter("job");
        String pageNo = request.getParameter("pageNo");
        String searchWord = request.getParameter("searchWord");

        response.setContentType("text/html; charset=UTF-8");
        //브라우저에 출력
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title></title></head>");
        out.println("<body>");

        out.println(job);
        out.println(pageNo);
        out.println(searchWord);

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        System.out.println("SendServlet doPost call");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String hobby = request.getParameter("hobby");
        String favorite = request.getParameter("favorite");
        String desc = request.getParameter("desc");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title></title></head>");
        out.println("<body>");

        out.println(name+"<br>");
        out.println(email+"<br>");
        out.println(gender+"<br>");
        out.println(hobby+"<br>");
        out.println(favorite+"<br>");
        out.println(desc);

        out.println("</body>");
        out.println("</html>");
    }
}
