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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/search",loadOnStartup = 1)
public class FindKeyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FindKeyServlet() {}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FindKeyServlet doPost");

        String keyField = req.getParameter("keyField");
        String keyWord = req.getParameter("keyWord");

        MemberDAO memberDAO = new MemberDAOImpl();
        List<MemberDTO> list = memberDAO.findByKeyFieldWord(keyField, keyWord);
        req.setAttribute("list", list);

        RequestDispatcher rd = req.getRequestDispatcher("/memberSelect.jsp");
        rd.forward(req, resp);
    }
}
