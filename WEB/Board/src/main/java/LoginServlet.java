import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/login", loadOnStartup = 1, initParams = {
        @WebInitParam(name = "dbId", value = "hong"),
        @WebInitParam(name = "dbPwd", value = "1234")
})
public class LoginServlet extends HttpServlet {
    private String dbId,dbPwd;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("userId");
        String userPwd = request.getParameter("userPwd");

        PrintWriter out = response.getWriter();

        if (dbId.equals(userId) && dbPwd.equals(userPwd)) {
            HttpSession session = request.getSession();
            session.setAttribute("sessionId", userId);
            session.setAttribute("creationTime", new Date().toLocaleString());

            //forward : request에 저장했을 경우 반드시!
            //redirect : session에 저장했을 경우(세션은 사실 상관없음) : 브라우저만 유지되면 상태는 유지되기 때문
            out.println("<script>");
            out.println("top.location.href='index.jsp';"); //top : 전체 창에 index가 열려라의 뜻
            //만약 location.href='index.jsp'이면, left 부분에 index.jsp가 또 띄워진다. ==left만 refresh된다.
            out.println("</script>");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            out.println("<script>");
            out.println("alert('정보를 다시 확인해주세요.');");
            out.println("history.back();");
            out.println("</script>");
        }
    }
}
