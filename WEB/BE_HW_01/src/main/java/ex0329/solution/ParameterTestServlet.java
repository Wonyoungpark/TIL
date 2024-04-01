package ex0329.solution;

import exam0329.vo.UserVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(loadOnStartup = 1, urlPatterns = "/params")
public class ParameterTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String job = request.getParameter("job");
        String pageNo = request.getParameter("pageNo");
        String searchWord = request.getParameter("searchWord");

        response.setContentType("text/html; charset=UTF-8");
        //브라우저에 출력
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title></title></head>");
        out.println("<body>");

        out.println(job);
        out.println(pageNo);
        out.println(searchWord);

        out.println("</body>");
        out.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String[] hobbys = request.getParameterValues("hobby");
        String favorite = request.getParameter("favorite");
        String desc = request.getParameter("desc");

        // 서비스 호출 -> dao 호출 -> DB에 INSERT

        // 속성들을 하나의 객체로 저장
        UserVO user = new UserVO(name,email,gender, hobbys,favorite,desc);

    }
}
