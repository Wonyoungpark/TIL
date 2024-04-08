package kosta.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kosta.dao.MemberDAO;
import kosta.dao.MemberDAOImpl;
import kosta.dto.MemberDTO;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/selectAll",loadOnStartup = 1)
public class SelectAllServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SelectAllServlet() {
        System.out.println("selectAllServlet constructor call");
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("selectAllServlet service call");

        MemberDAO memberDAO = new MemberDAOImpl();
        List<MemberDTO> list = memberDAO.selectAll();
        req.setAttribute("list", list);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/memberSelect.jsp");
        dispatcher.forward(req,resp);
    }
}
