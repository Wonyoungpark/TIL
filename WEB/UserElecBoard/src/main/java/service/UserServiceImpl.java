package service;

import dao.UserDAO;
import dao.UserDAOImpl;
import dto.UserDTO;
import exception.AuthenticationException;

import java.io.IOException;
import java.sql.SQLException;

public class UserServiceImpl implements UserService, UserDAO {
    UserDAO userDAO = new UserDAOImpl();

    public UserServiceImpl() throws IOException {}

    @Override
    public UserDTO loginCheck(UserDTO userDTO) throws SQLException, AuthenticationException {
        UserDTO user = userDAO.loginCheck(userDTO);
        String userId = user.getUserId();
        String pwd = user.getPwd();
        if (userId == null || userId.isEmpty() || pwd == null || pwd.isEmpty())
            throw new AuthenticationException("아이디와 비밀번호를 정확히 입력해주세요.");

        return userDTO;
    }
}
