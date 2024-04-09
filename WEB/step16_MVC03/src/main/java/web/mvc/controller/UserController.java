package web.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/*
회원 전용 Controller
 */
public class UserController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }

    /*
    로그인
     */
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UserController login");

        //로그인 기능
        HttpSession session = request.getSession();
        session.setAttribute("sessionMessage","로그인 성공");
//        session.setAttribute("username","admin");
        return new ModelAndView("user/login.jsp",true); //session은 이동 방식이 상관없은 -> redirect
    }

    /*
    회원정보 수정
     */
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UserController update");

        //수정 기능
        request.setAttribute("message","회원 정보 수정 완료");
        return new ModelAndView("user/update.jsp");
    }
}
