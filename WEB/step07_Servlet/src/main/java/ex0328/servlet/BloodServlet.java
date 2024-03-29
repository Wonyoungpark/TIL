package ex0328.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class BloodServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BloodServlet() {
        System.out.println("BloodServlet 생성자 call");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("BloodServlet service call");

        //전송 데이터 받기
        String name = request.getParameter("name");
        String blood = request.getParameter("blood");

        response.setContentType("text/html; charset=UTF-8");
        //브라우저에 출력
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title></title></head>");
        out.println("<body>");

        //FORWARD METHOD
        String file;
//        if ("A".equals(blood)) file = "/blood/A.jsp";
//        else if ("B".equals(blood)) file = "/blood/B.jsp";
//        else if ("O".equals(blood)) file = "/blood/O.jsp";
//        else file = "/blood/AB.jsp";
//        RequestDispatcher rd = request.getRequestDispatcher(file);

        RequestDispatcher rd = request.getRequestDispatcher("/blood/"+blood+".jsp");
        rd.forward(request,response);

        out.println("</body>");
        out.println("</html>");
    }

}