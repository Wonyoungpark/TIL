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

@WebServlet(urlPatterns = "/insert", loadOnStartup = 1)
public class InsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public InsertServlet() {
        System.out.println("InsertServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("InsertServlet doPost call");

        String url = "error.jsp";
        String errMsg = "회원가입이 실패했습니다. 정보를 정확히 입력해주세요.";
        boolean isRedirect = false;

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String phone = req.getParameter("phone");
        String addr = req.getParameter("addr");

        //유효성 체크
        if (id == null || id.equals("") || pwd == null || pwd.equals("") || name == null || name.equals("") ||
                age == 0 || phone == null || phone.equals("") || addr == null || addr.equals("")) {
            errMsg = "값이 충분히 입력되지 않았습니다. 올바르게 입력해주세요.";
        } else {
            //중복체크
            MemberDAO dao = new MemberDAOImpl();
            if (dao.getSelectById(id) != null) {
                errMsg = id + "는 이미 사용 중입니다.";
            } else {
                //등록하기
                MemberDTO member = new MemberDTO(id, pwd, name, age, phone, addr, null);
                if (dao.insert(member) > 0) {
                    url = "selectAll";
//                    url = "index.jsp";
                    isRedirect = true;
                }
            }
        }

        //모든 것이 성공하면 selectAllServlet 이동 : redirect 방식
        //오류가 있으면 errMsg를 scope에 저장하고 error.jsp이동 : forward 방식
        if (isRedirect) {
            resp.sendRedirect(url);
        } else {
            req.setAttribute("errMsg", errMsg);
            req.getRequestDispatcher(url).forward(req, resp);
        }

    }
}
