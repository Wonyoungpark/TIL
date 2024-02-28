package dao;

import util.DbManager;
import vo.Room;
import vo.Student;
import vo.Subject;
import vo.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoTest {
    public List<Student> getGenderByWomen(){
        Connection con = null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        List<Student> list=new ArrayList<Student>();
        String sql ="select * from student where  수_주민등록번호 like '%-2%'";
        try{
            con= DbManager.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){

            }
        }
    }

    public List<Teacher> getTeacherInfoByAddr(String gu){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Teacher> list=new ArrayList<Teacher>();

//        String sql="select * from teacher  where 주소 like '%' || ? || '%'";
        String sql="select * from teacher  where 주소 like ?"
        try{
            con=DbManager.getConnection();
        }
    }

    public Teacher getTeacherInfoBySubject(String subject);{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        Teacher teacher=null;
        String sql="select * from teacher where 수강코드 = \n" +
                "(select 수강코드 from subject where upper(과목)=upper( ? ))";

        try{
            con=DbManager.getConnection();

        }
    }

    public Teacher getTeacherInfoByNo(int teacherNo){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Teacher teacher=null;
        String sql="select * from v_teacherInfo  where 강사번호=?";

        try {
            con=DbManager.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,teacherNo);

            rs=ps.executeQuery();
            if(rs.next()){
                teacher = new Teacher();
                teacher.setTeacherNo(rs.getInt(1));
                teacher.setTeacherName(rs.getString(2));
                teacher.setSubject(new Subject(rs.getString(3), rs.getString(4))); //has A 관계
                teacher.setRoom(new Room(rs.getInt(5),rs.getInt(6)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            DbManager.dbClose(con,ps,rs);
        }
    }
}
