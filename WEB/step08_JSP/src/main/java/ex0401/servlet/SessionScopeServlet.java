package ex0401.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/sessionServlet",loadOnStartup = 1) //@WebServlet : 생성
public class SessionScopeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        //정보 조회
        System.out.println("REQUEST");
        System.out.println("아이디 : "+request.getAttribute("id"));
        System.out.println("나이 : "+request.getAttribute("age"));

        //HttpSession 가져오기
        System.out.println("SESSION");
        HttpSession session = request.getSession();
        System.out.println("메시지 : "+session.getAttribute("message"));
        System.out.println("아이디 : "+session.getAttribute("id"));
    }
}
