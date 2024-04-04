package ex0404.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class SampleFilter implements Filter {
    public SampleFilter(){
        System.out.println("ex0404.filter.SampleFilter Constructor call");
    }
    public void init(FilterConfig fConfig) throws ServletException{
        System.out.println("ex0404.filter.SampleFilter init call");
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("ex0404.filter.SampleFilter 사전 처리 중");
        chain.doFilter(request,response); //실제 요청된 타깃 대상 호출
        System.out.println("ex0404.filter.SampleFilter 사후 처리");
    }
    public void distroy(){
        System.out.println("ex0404.filter.SampleFilter distroy call");
    }
}
