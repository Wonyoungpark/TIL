package ex0328.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HobbyServlet extends HttpServlet {
    private static final long serialVersionID = 1L;

    public HobbyServlet(){
        System.out.println("HobbyServlet 생성자 call");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("HobbyServlet service call");

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String[] values = request.getParameterValues("hobby");

        response.setContentType("text/html; charset=UTF-8");
        //브라우저에 출력
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title></title></head>");
        out.println("<body>");

        out.println("<h2>");
        out.println(name+"<br>");
        out.println(age+"<br>");
        out.println("</h2>");

        out.println("<p>");
        for(int i=0;i<values.length;i++)
            out.println(values[i]+" | ");
        out.println("</p>");

        out.println("</body>");
        out.println("</html>");
    }
}
