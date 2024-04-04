package ex0404.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogTest {
    Log log = LogFactory.getLog(super.getClass());

    public static void main(String[] args) {
        System.out.println("LOG TEST START");

        new LogTest().test();
        System.out.println("LOG TEST END");
    }

    public void test(){
        //log 기록
        log.trace("trace 로그");
        log.debug("debug 로그");
        log.info("info 로그");
        log.warn("warn 로그");
        log.error("error 로그");
        log.fatal("fatal 로그");

    }
}
