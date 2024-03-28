package ex0328.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        System.out.println("LoginServlet 생성자 call");
    }

    @Override
    protected void service (HttpServletRequest arg0,HttpServletResponse arg1) throws ServletException{
        System.out.println("LoginServlet service call");
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("LoginServlet doGet call");
//    }
//
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("LoginServlet doPost call");
//    }
}
