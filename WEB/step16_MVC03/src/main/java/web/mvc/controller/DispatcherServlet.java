package web.mvc.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

@WebServlet(urlPatterns = "/front", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
    private Map<String, Controller> map;
    private Map<String, Class<?>> classMap;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext application = config.getServletContext();
        map = (Map<String, Controller>) application.getAttribute("map");
        classMap = (Map<String, Class<?>>) application.getAttribute("classMap");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DispatcherServlet service call");

        String key = request.getParameter("key");
        String methodName = request.getParameter("methodName");
        System.out.println("key = " + key + ", methodName = " + methodName);

        Controller controller = map.get(key);
        Class<?> className = classMap.get(key);

        //String의 methodName을 Method 타입으로 변환
        Method method = null;
        try {
            method = className.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            ModelAndView mv = (ModelAndView) method.invoke(controller, request, resp); //메소드 호출

            if (mv.isRedirect()) { //redirect 방식
                resp.sendRedirect(mv.getViewName());
            } else { //forward 방식
                request.getRequestDispatcher(mv.getViewName()).forward(request, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
