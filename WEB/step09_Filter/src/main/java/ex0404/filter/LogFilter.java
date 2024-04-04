package ex0404.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class LogFilter implements Filter {
    Log log = LogFactory.getLog(super.getClass());

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("LOG RECORD START");

        //접속자 ip,url주소(요청주소) 기록, 총 소요시간(ms)
        String ip = req.getRemoteAddr();

        HttpServletRequest request = (HttpServletRequest)req;
        String url = request.getRequestURL().toString();
        log.debug("ip = "+ip+" ,url = "+url);

        //현재 시간
        long start = System.currentTimeMillis();

        chain.doFilter(req, res);

        //현재 시간
        long end = System.currentTimeMillis();

        log.debug("총 소요 ms : "+(end-start)+"ms");

        System.out.println("LOG RECORD END");
    }
}
