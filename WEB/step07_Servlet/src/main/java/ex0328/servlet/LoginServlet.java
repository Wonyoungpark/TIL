package ex0328.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String dbId = "hong", dbPwd = "1234";

    public LoginServlet() {
        System.out.println("LoginServlet 생성자 call");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet service call");

        //전송 데이터 받기
        String userId = request.getParameter("userId");
        String userPwd = request.getParameter("userPwd");
        String userName = request.getParameter("userName");

        System.out.println(userId);
        System.out.println(userPwd);
        System.out.println(userName);

        response.setContentType("text/html; charset=UTF-8");
        //브라우저에 출력
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title></title></head>");
        out.println("<body>");

//        out.println("<h3>");
//        out.println("아이디 : "+userId+"<br>");
//        out.println("비밀번호 : "+userPwd+"<br>");
//        out.println("이름 : "+userName);
//        out.println("</h3>");

        //id & pwd 비교
        if (dbId.equals(userId) && dbPwd.equals(userPwd)) {//필수존재값.equals(입력값) //dbId는 무조건 null 발생이 없기 때문에 안정적
//            response.sendRedirect("LoginOk.html");
//            out.println("<a href='LoginOk.html'/>");

            //REDIRECT METHOD
//            새로운 request,response를 생성해서 이동
            String encUserName = URLEncoder.encode(userName, "UTF-8");
            response.sendRedirect("LoginResult.jsp?userName=" + encUserName);


            //FORWARD METHOD
//            RequestDispatcher rd = request.getRequestDispatcher("LoginResult.jsp");
//            rd.forward(request,response); //기존 request,response 유지된다.
        }
        else {
//            out.println("<script>");
//            out.println("<alert('아이디와 비밀번호가 틀렸습니다.');");
//            out.println("</script>");
//            response.sendRedirect("LoginForm.html");
            // script는 정적코드이고, sendRedirect는 동적코드
            // => 동적코드가 먼저 실행되기 때문에 페이지가 이미 변경되었으므로 정적코드는 실행되지 못한다.

            out.println("<script>");
            out.println("alert('아이디와 비밀번호가 틀렸습니다.');");
            out.println("location.href='LoginForm.html'");
//            out.println("history.back();"); //뒤로가기
            out.println("</script>");
        }

        out.println("</body>");
        out.println("</html>");
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("LoginServlet doGet call");
//    }
//
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("LoginServlet doPost call");
//    }
}
