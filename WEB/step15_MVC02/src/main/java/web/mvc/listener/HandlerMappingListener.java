package web.mvc.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import web.mvc.controller.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@WebListener
public class HandlerMappingListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("HandlerMappingListener contextInitialized");

        Map<String, Controller> map = new HashMap<String, Controller>();

//        1. 외부 Properties 파일 로드
//        1) resource bundle 2) properties
        ResourceBundle rb = ResourceBundle.getBundle("actionMapping"); // resources/actionMapping.properties

        try {
            for (String key : rb.keySet()) {
//        2. 반복문으로 key,value 분리
                String value = rb.getString(key);

//        3. value를 객체로 변환
                Class<?> className = Class.forName(value);
                Controller controller = (Controller)className.getDeclaredConstructor().newInstance();

//        4. map에 저장
                map.put(key,controller);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        5. application 영역에 map 저장 : Dispatcher 영역에서도 사용하기 위해 전역에 저장한다.
        ServletContext application = sce.getServletContext();
        application.setAttribute("map",map);

        application.setAttribute("rootPath",application.getContextPath()); //${rootPath}
    }
}
