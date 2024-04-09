package web.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SelectController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SelectController");

        //서비스 호출

        //결과 받기
        request.setAttribute("message","전체검색결과");
        ModelAndView mv = new ModelAndView("selectResult.jsp");

        return mv;
    }
}
