package service;

import java.sql.SQLException;

import dto.UserDTO;
import exception.AuthenticationException;

public interface UserService {
	/**
	 * 로그인 체크
	 * */
   UserDTO loginCheck(UserDTO userDTO) throws SQLException, AuthenticationException;
}
