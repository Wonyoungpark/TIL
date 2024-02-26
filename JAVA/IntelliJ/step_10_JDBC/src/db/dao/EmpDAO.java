package db.dao;

import db.util.DbManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpDAO {
    //EMP테이블에서 사원 이름 검색
    //select ename from emp;

    public void selectByName(){
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        String sql = "select ename from emp";

        try {
            // 로드

            // 연결
            con = DbManager.getConnection();
            // 실행
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                //열 조회
                String ename = rs.getString("ENAME");
                System.out.println(ename);
            }
            System.out.println("===조회 완료===");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 닫기
            DbManager.dbClose(con,st,rs);
        }

    }
}
