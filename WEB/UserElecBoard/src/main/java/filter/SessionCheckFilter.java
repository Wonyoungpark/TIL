package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = "/front")
public class SessionCheckFilter implements Filter {
    public SessionCheckFilter() {
        System.out.println("SessionCheckFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("SessionCheckFilter doFilter");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        //methodName 확인
        String key = request.getParameter("key");
        if (key==null || key.isEmpty() || "elec".equals(key)){
            //sessionScope 확인
            if(session.getAttribute("loginUser")==null) {
                request.setAttribute("errorMsg","로그인 후에 이용해주세요");
                request.getRequestDispatcher("error/error.jsp").forward(request, servletResponse);
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
