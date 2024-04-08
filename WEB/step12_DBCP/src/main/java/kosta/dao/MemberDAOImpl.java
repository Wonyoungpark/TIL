package kosta.dao;

import kosta.dto.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {
    @Override
    public List<MemberDTO> selectAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<MemberDTO> list = new ArrayList<MemberDTO>();
        String sql = "select * from member order by join_date desc";

        try{
            conn = DbManager.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                MemberDTO member = new MemberDTO(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(member);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbManager.dbClose(conn, ps, rs);
        }
        return list;
    }

    @Override
    public int insert(MemberDTO memberDTO) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into member values(?,?,?,?,?,?,SYSDATE)";
        int result = 0;

        try{
            conn = DbManager.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1,memberDTO.getId());
            ps.setString(2,memberDTO.getPwd());
            ps.setString(3,memberDTO.getName());
            ps.setInt(4,memberDTO.getAge());
            ps.setString(5,memberDTO.getPhone());
            ps.setString(6,memberDTO.getAddr());

            result = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbManager.dbClose(conn, ps);
        }
        return result;
    }

    @Override
    public MemberDTO getSelectById(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MemberDTO member = null;
        String sql = "select * from member where id = ?";

        try{
            conn = DbManager.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            rs = ps.executeQuery();

            if(rs.next()) {
                member = new MemberDTO(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbManager.dbClose(conn, ps, rs);
        }
        return member;
    }

    @Override
    public int delete(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "delete from member where id = ?";
        int result = 0;

        try {
            conn = DbManager.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            result = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbManager.dbClose(conn, ps);
        }
        return result;
    }

    @Override
    public int update(MemberDTO memberDTO) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "update member set pwd = ?, age=?, addr=?,phone=? where id = ?";
        int result = 0;

        try {
            conn = DbManager.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,memberDTO.getPwd());
            ps.setInt(2,memberDTO.getAge());
            ps.setString(3, memberDTO.getAddr());
            ps.setString(4,memberDTO.getPhone());
            result = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbManager.dbClose(conn, ps);
        }
        return result;
    }

    @Override
    public List<MemberDTO> findByKeyFieldWord(String keyField, String keyWord) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<MemberDTO> list = new ArrayList<MemberDTO>();
        String sql = "select * from member where "+keyField+"=? order by join_date desc";

        try{
            conn = DbManager.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,keyWord);
            rs = ps.executeQuery();

            while(rs.next()) {
                MemberDTO member = new MemberDTO(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(member);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbManager.dbClose(conn, ps, rs);
        }
        return list;
    }
}
