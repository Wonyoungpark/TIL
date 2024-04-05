package ex0405.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class UserAccessCounterListener implements ServletContextListener, HttpSessionListener {

    //서버가 시작될 때, applicationScope 영역에 nowCounter의 값 0으로 초기화
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("UserAccessCounterListener contextInitialized call");

        ServletContext application = sce.getServletContext();
        application.setAttribute("nowCounter", new AtomicInteger());
    }

    //nowCounter 1증가
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("UserAccessCounterListener sessionCreated call");

        Object cnt = se.getSession().getAttribute("nowCounter");
        AtomicInteger counter = (AtomicInteger) cnt;
        counter.getAndIncrement();
        System.out.println("증가된 참가자 수 : "+counter.get());
    }

    //nowCounter의 값 1 감소
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("UserAccessCounterListener sessionDestroyed call");
        Object cnt = se.getSession().getAttribute("nowCounter");
        AtomicInteger counter = (AtomicInteger) cnt;
        counter.decrementAndGet();
        System.out.println("감소된 참가자 수 : "+counter.get());
    }
}
