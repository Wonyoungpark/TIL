package ex0405.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.util.HashMap;
import java.util.Map;

/*
ServletContextListener : 서버가 start/stop될 때 이벤트 처리하는 핸들러
 */
public class AppListener implements ServletContextListener {
    public AppListener() {
        System.out.println("AppListener created");
    }

    // 서버 시작
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("AppListener contextInitialized call");

        // 각 나라 별 국가코드와 나라명을 map에 저장
        Map<String,String> nationMap = new HashMap<String,String>();
        nationMap.put("kr","대한민국");
        nationMap.put("cn","중국");
        nationMap.put("jp","일본");
        nationMap.put("us","미국");
        nationMap.put("fr","프랑스");

        // 모든 영역에서 사용하도록 application에 저장
        ServletContext application = sce.getServletContext();
        application.setAttribute("nationMap",nationMap); //모든 뷰(jsp) : ${applicationScope.nationMap} & servlet : application.getAttribute("nationMap")에서 사용 가능

        //Path 선언
        application.setAttribute("rootPath",application.getContextPath()); // ${rootPath}
    }

    //서버 종료
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("AppListener contextDestroyed call");
    }
}
