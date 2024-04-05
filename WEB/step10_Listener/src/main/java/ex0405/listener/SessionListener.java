package ex0405.listener;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    public SessionListener() {
        System.out.println("SessionListener created");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("SessionListener sessionCreated created");
    }

    /*
    1) session.invalidate();
    2) session timeout 되었을 때
    3) 브라우저를 닫았을 때 호출되지 않는다!
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("SessionListener sessionDestroyed created");
    }
}
