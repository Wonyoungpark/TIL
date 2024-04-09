package web.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class InsertController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("InsertController");

        //등록 기능 : 서비스 호출 -> 결과 받기 -> index 이동

        return new ModelAndView("index.jsp",true);
    }
}
