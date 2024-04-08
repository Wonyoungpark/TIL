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

@WebServlet(urlPatterns = "/read", loadOnStartup = 1)
public class SelectByIdServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SelectByIdServlet() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SelectByIdServlet service");
        String id = req.getParameter("id");
        String url;

        MemberDAO memberDAO = new MemberDAOImpl();
        MemberDTO member = memberDAO.getSelectById(id);
        if (member == null) {
            req.setAttribute("errMsg","해당 id와 일치하는 정보가 없습니다.");
            url = "error.jsp";
        }else{
            req.setAttribute("member", member);
            url = "/read.jsp";
        }

        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req,resp);
    }
}
