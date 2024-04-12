package controller;

import dto.UserDTO;
import exception.AuthenticationException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserService;
import service.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

public class UserController implements Controller {
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public UserController() throws IOException {}

    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("UserController login");
        String userId = request.getParameter("userId");
        String pwd = request.getParameter("pwd");

        try {
            UserDTO userDTO = userService.loginCheck(new UserDTO(userId,pwd));

            HttpSession session = request.getSession();
            session.setAttribute("loginUser",userDTO);
            session.setAttribute("loginName",userDTO.getName());
        }catch (SQLException | AuthenticationException e){
            e.printStackTrace();
        }

        return new ModelAndView("index.jsp",true);
    }

    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("UserController logout");

        HttpSession session = request.getSession();
        session.invalidate();
        return new ModelAndView("index.jsp",true);
    }
}
