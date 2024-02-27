package db.dao;

import db.dto.Emp;
import db.util.DbManager;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    //전체검색
    //select empno,ename,job,sal,hiredate from emp
    public List<Emp> selectAll(){
        //로드
        //실행
        //finally{}에서 자원을 반납하기 위해서 밖에서 정의
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        String sql = "select empno,ename,job,sal,hiredate from emp";
        List<Emp> list = new ArrayList<Emp>();

        try{
            //연결
            con = DbManager.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                //열 조회
                Emp emp = new Emp(rs.getInt("empno"),rs.getString("ename"),
                        rs.getString(3),rs.getInt(4),rs.getString("hiredate"));
                list.add(emp);
            }
        }catch (Exception e){

        }finally {
            //닫기
            DbManager.dbClose(con,st,rs);
        }
        return list;
    }

    //사원번호에 해당하는 사원정보 검색
    public Emp selectByEmpno(int empno){ //PK대상으로 한 검색은 결과가 레코드 하나 //리턴값이 리스트가 아니다.
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        Emp emp=null;
        String sql="select empno,ename,job,sal,hiredate from emp where empno="+empno;

        try{
            con = DbManager.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            if(rs.next()) emp = new Emp(rs.getInt("empno"),rs.getString("ename"),
                    rs.getString(3),rs.getInt(4),rs.getString("hiredate"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbManager.dbClose(con,st,rs);
        }
        return emp;
    }

    //사원등록
    public int insert(Emp emp){
        Connection con=null;
        Statement st=null;
        int result=0;
        String sql="insert into emp(empno,ename,job,sal,hiredate) " +
                "values("+emp.getEmpno()+",'"+emp.getEname()+"','"+
                emp.getJob()+"',"+emp.getSal()+",sysdate)";

        try{
            System.out.println("sql= "+sql);
            con = DbManager.getConnection();
            st = con.createStatement();
            result = st.executeUpdate(sql);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbManager.dbClose(con,st);
        }
        return result;
    }

    //사원등록 (PreparedStatement 방식)
    public int prepareInsert(Emp emp){
        Connection con=null;
        PreparedStatement ps=null;
        int result=0;
        String sql="insert into emp(empno,ename,job,sal,hiredate) " +
                "values(?,?,?,?,sysdate)";

        try{
            System.out.println("sql= "+sql);
            con = DbManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,emp.getEmpno());
            ps.setString(2,emp.getEname());
            ps.setString(3,emp.getJob());
            ps.setInt(4,emp.getSal());
            result = ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbManager.dbClose(con,ps);
        }
        return result;
    }
}
