package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

@WebServlet(urlPatterns = "/front",loadOnStartup = 1)
@MultipartConfig( //어노테이션을 통해  서블릿이 파일 업로드 기능을 할 수 있도록 웹 컨테이너에 지시
        maxFileSize = 1024 * 1024 * 5, //5M - 한 번에 업로드 할 수 있는 파일 크기 제한
        maxRequestSize = 1024 * 1024 * 50 //50M -전체 요청의 크기 제한. 기본값은 무제한
)
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Map<String, Controller> map;
    private Map<String, Class<?>> clzMap;

    public DispatcherServlet() {
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext application = config.getServletContext();
        map = (Map<String, Controller>) application.getAttribute("map");
        clzMap = (Map<String, Class<?>>) application.getAttribute("clzMap");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DispatcherServlet service");
        String key = req.getParameter("key");
        String methodName = req.getParameter("methodName");

        if ((key == null || key.isEmpty()) && (methodName == null || methodName.isEmpty())) {
            key = "elec";
            methodName = "select";
        }
        System.out.println("key: " + key + ", methodName: " + methodName);

        Controller controller = map.get(key);
        Class<?> className = clzMap.get(key);

        Method method = null;
        try {
            method = className.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            ModelAndView mv = (ModelAndView) method.invoke(controller, req, resp); //메소드 호출

            if (mv.isRedirect()) resp.sendRedirect(mv.getViewName());
            else req.getRequestDispatcher(mv.getViewName()).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
