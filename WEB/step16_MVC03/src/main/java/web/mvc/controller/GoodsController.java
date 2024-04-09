package web.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

public class GoodsController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }

    /*
    상품 목록 가져오기
     */
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GoodsController.list");

        request.setAttribute("goodsList", Arrays.asList("사과","딸기","포도"));
        return new ModelAndView("goods/list.jsp");
    }

    /*
    상품 등록
     */
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GoodsController.registerOk");

        return new ModelAndView("goods/registerOk.jsp",true);
    }
}
