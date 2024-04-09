package web.mvc.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/front", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
    private Map<String, Controller> map;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext application = config.getServletContext();
        map = (Map<String, Controller>) application.getAttribute("map");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DispatcherServlet service call");

        String key = request.getParameter("key");
        System.out.println("key = " + key);

        Controller controller = map.get(key);

        ModelAndView mv = controller.handleRequest(request, resp);
        if (mv.isRedirect()) { //redirect 방식
            resp.sendRedirect(mv.getViewName());
        } else { //forward 방식
            request.getRequestDispatcher(mv.getViewName()).forward(request, resp);
        }
    }
}
