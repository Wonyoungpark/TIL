package web.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/front", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DispatcherServlet() {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DispatcherServlet service call");

        String key = request.getParameter("key");
        System.out.println("key = " + key);

        Controller controller = null;
        if ("select".equals(key)) {
            controller = new SelectController();
        } else if ("update".equals(key)) {
            controller = new UpdateController();
        } else if ("delete".equals(key)) {
            controller = new DeleteController();
        } else if ("insert".equals(key)) {
            controller = new InsertController();
        }

        ModelAndView mv = controller.handleRequest(request, resp);
        if (mv.isRedirect()) {
            //redirect 방식
            resp.sendRedirect(mv.getViewName());
        } else {
            //forward 방식
            request.getRequestDispatcher(mv.getViewName()).forward(request, resp);
        }
    }
}
