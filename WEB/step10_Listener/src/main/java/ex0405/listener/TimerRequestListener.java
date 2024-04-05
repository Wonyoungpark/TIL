package ex0405.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

public class TimerRequestListener implements ServletRequestListener {
    private long start, end;

    public TimerRequestListener() {
        System.out.println("TimerRequestListener constructor call");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("TimerRequestListener destroyed call");

        end = System.currentTimeMillis();
        System.out.println("총 소요 : " + (end - start) + "ms");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("TimerRequestListener initialized call");

        start = System.currentTimeMillis();
    }
}
