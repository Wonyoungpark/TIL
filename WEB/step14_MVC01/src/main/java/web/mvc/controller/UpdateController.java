package web.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UpdateController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UpdateController");

        //수정 기능 : service() -> DAO
        request.setAttribute("message","수정이 완료되었습니다.");
        return new ModelAndView("updateResult.jsp");
    }
}
