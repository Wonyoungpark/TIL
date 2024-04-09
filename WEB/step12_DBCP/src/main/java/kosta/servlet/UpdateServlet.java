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
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/update",loadOnStartup = 1)
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateServlet() {}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UpdateServlet doGet");
        String id = req.getParameter("id");

        MemberDAO memberDAO = new MemberDAOImpl();
        MemberDTO member = memberDAO.getSelectById(id);
        req.setAttribute("member", member);
        req.getRequestDispatcher("updateForm.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UpdateServlet doPost");
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        int age = Integer.parseInt(req.getParameter("age"));
        String addr = req.getParameter("addr");
        String phone = req.getParameter("phone");

        MemberDAO memberDAO = new MemberDAOImpl();
        int result = memberDAO.update(new MemberDTO(id,pwd,age,addr,phone));

        if(result == 1) {
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.println("<script type='text/javascript'>");
            out.println("alert('성공적으로 수정되었습니다.');");
            out.println("top.location.href='selectAll'");
            out.println("</script>");
//            resp.sendRedirect("selectAll");
        }else{
            req.setAttribute("errMsg","업데이트에 실패했습니다. 다시 시도해주세요.");
            RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
            rd.forward(req, resp);
        }
    }
}
