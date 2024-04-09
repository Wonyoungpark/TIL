package web.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BoardController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }

    /*
    게시물 검색하기
     */
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("BoardController list");

        request.setAttribute("message","BOARD LIST");
        return new ModelAndView("board/list.jsp");
    }

    /*
    상세보기
     */
    public ModelAndView read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("BoardController read");

        return new ModelAndView("board/read.jsp",true);
    }
}
