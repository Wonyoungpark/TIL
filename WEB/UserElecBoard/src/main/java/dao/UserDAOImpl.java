package dao;

import dto.UserDTO;
import util.DbUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class UserDAOImpl implements UserDAO {
    Properties proFile = new Properties();

    public UserDAOImpl() throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
        proFile.load(is);
    }

    @Override
    public UserDTO loginCheck(UserDTO userDTO) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFile.getProperty("query.userlogin");

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userDTO.getUserId());
            ps.setString(2, userDTO.getPwd());
            rs = ps.executeQuery();
            if (rs.next()) {
                userDTO.setUserId(rs.getString("user_id"));
                userDTO.setPwd(rs.getString("pwd"));
                userDTO.setName(rs.getString("name"));
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return userDTO;
    }
}
