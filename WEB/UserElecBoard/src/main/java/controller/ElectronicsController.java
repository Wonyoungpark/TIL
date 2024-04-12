package controller;

import dto.Electronics;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service.ElectronicsService;
import service.ElectronicsServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ElectronicsController implements Controller {
    ElectronicsService electronicsService = new ElectronicsServiceImpl();

    public ElectronicsController() throws IOException {
        System.out.println("Electronics Controller");
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public ModelAndView select(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Electronics Controller select");

        try {
            List<Electronics> list = electronicsService.selectAll();
            request.setAttribute("list", list);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView("elec/list.jsp");
    }

    private String getFilename(Part part) {
        String headerContext = part.getHeader("content-disposition");
        String[] split = headerContext.split(";");
        for (int i = 0; i < split.length; i++) {
            String temp = split[i];
            if (temp.trim().startsWith("filename")) {
                return temp.substring(temp.indexOf("=") + 2, temp.length() - 1);
            }
        }
        return null;
    }
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Electronics Controller insert");

        try{
            Part part = request.getPart("file");
            String fileName = this.getFilename(part);
            long fileSize = part.getSize();

            Electronics electronics = new Electronics(request.getParameter("model_num"),request.getParameter("model_name"),
                    Integer.parseInt(request.getParameter("price")),request.getParameter("description"),request.getParameter("password"),
                    fileName, (int)fileSize);

            electronicsService.insert(electronics);
        }catch (SQLException | ServletException | IOException e){
            e.printStackTrace();
        }
        return new ModelAndView("front",true);
    }

    public ModelAndView selectByModelNum(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Electronics Controller selectByModelNum");

        try {
            Electronics electronics = electronicsService.selectByModelnum(request.getParameter("modelNum"),true);
            request.setAttribute("elec", electronics);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView("elec/read.jsp");
    }

    public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Electronics Controller updateForm");

        try{
            Electronics electronics = electronicsService.selectByModelnum(request.getParameter("modelNum"),false);

            request.setAttribute("elec", electronics);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView("elec/update.jsp");
    }

    public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Electronics Controller update");

        try{
            Electronics electronics = new Electronics(request.getParameter("modelNum"),request.getParameter("modelName"),
                    Integer.parseInt(request.getParameter("price")), request.getParameter("description"),
                    request.getParameter("password"));
            electronicsService.update(electronics);
            request.setAttribute("elec", electronics);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ModelAndView("elec/read.jsp");
    }
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Electronics Controller delete");

        try {
            electronicsService.delete(request.getParameter("modelNum"),request.getParameter("password"),request.getParameter("fname"));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ModelAndView("front",true);
    }
}
