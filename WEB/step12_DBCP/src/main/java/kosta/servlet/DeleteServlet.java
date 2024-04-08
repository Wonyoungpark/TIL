package kosta.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kosta.dao.MemberDAO;
import kosta.dao.MemberDAOImpl;

import java.io.IOException;

@WebServlet(urlPatterns = "/delete",loadOnStartup = 1)
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteServlet() {}
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("Delete Servlet doPost");
        String id = req.getParameter("id");

        MemberDAO memberDAO = new MemberDAOImpl();
        int result = memberDAO.delete(id);
        if(result == 1){
            resp.sendRedirect("selectAll");
        }else{
            req.setAttribute("errMsg","삭제되지 않았습니다. 다시 시도해주세요.");
            RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
            rd.forward(req,resp);
        }
    }
}
