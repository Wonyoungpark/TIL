package util;

import java.sql.*;

/**
 * 로드 연결 닫기 기능 제공
 */
public class DbManager {
    //로드
    static {
        try {
            Class.forName(DbProperties.DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //연결
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DbProperties.URL,DbProperties.USER_ID,DbProperties.USER_PWD);
    }

    //닫기(DML,DDL) //닫는 순서는 LIFO
    public static void dbClose(Connection con, Statement st){
        try {
            if(st!=null) st.close();
            if(con!=null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //닫기(SELECT)
    public static void dbClose(Connection con, Statement st, ResultSet rs){
        try {
            if(rs!=null) rs.close();
            dbClose(con,st);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
