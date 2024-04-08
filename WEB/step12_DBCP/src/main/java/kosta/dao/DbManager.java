package kosta.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//로드 연결 닫기
public class DbManager {
    private static DataSource ds;

    //DBCP 로드
    //DataSource 얻어오는건 늘 필요하기 때문에 initialize할 때 얻어온다.
    static {
        try {
            Context initContext = new InitialContext();

//            Context envContext = (Context) initContext.lookup("java:/comp/env");
//            DataSource ds = (DataSource) initContext.lookup("jdbc/myoracle");
            ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/myoracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //연결 요청
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //닫기 (select 전용)
    public static void dbClose(Connection con, Statement st, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            dbClose(con, st);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //닫기 (DML 전용)
    public static void dbClose(Connection con, Statement st) {
        try {
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
