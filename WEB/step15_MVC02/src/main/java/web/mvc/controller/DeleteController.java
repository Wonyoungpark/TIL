package web.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("DeleteController");

        //삭제 기능 : 삭제 -> SelectController 호출

        return new ModelAndView("front?key=select",false);
    }
}
