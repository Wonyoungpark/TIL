import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

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
        String userName = request.getParameter("userName");

        if (dbId.equals(userId) && dbPwd.equals(userPwd)) {
            HttpSession session = request.getSession();
            session.setAttribute("sessionId", userId);
            session.setAttribute("sessionName", userName);

            //로그인된 시간
            Calendar cal = Calendar.getInstance();//현재 날짜와 시간 설정
            int y = cal.get(Calendar.YEAR);
            int m = cal.get(Calendar.MONTH) + 1;
            int d = cal.get(Calendar.DATE);
            int h = cal.get(Calendar.HOUR);
            int min = cal.get(Calendar.MINUTE);
            int s = cal.get(Calendar.SECOND);

            StringBuilder sb = new StringBuilder();
            sb.append(y + "년");
            sb.append(m + "월");
            sb.append(d + "일");
            sb.append(h + "시");
            sb.append(min + "분");
            sb.append(s + "초");

            session.setAttribute("creationTime", sb.toString());

            response.sendRedirect("left.jsp"); //session에 저장됐을 때 이동방식은 중요하지 않음 (브라우저만 유지되면 상태는 유지되기 때문)
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('" + userName + "님 정보를 다시 확인해주세요.')");
            out.println("history.back();");
            out.println("</script>");
        }
    }
}
