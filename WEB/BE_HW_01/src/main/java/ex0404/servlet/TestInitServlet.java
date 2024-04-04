package ex0404.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class TestInitServlet extends HttpServlet {
    public TestInitServlet(){
        System.out.println("TestInitServlet Constructor call");
    }

    @Override
    public void init(ServletConfig config) throws ServletException{
        System.out.println("TestInitServlet init call");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestInitServlet service call");
    }
}
