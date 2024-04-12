package filter;

import jakarta.servlet.*;

import java.io.IOException;

public class EncodingFilter implements Filter {
    public EncodingFilter() {
        System.out.println("EncodingFilter");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("EncodingFilter init");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("EncodingFilter - doFilter");
    }
}
