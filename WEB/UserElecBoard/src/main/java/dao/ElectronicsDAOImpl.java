package dao;

import dto.Electronics;
import paging.PageCnt;
import util.DbUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ElectronicsDAOImpl implements ElectronicsDAO{
    Properties proFile = new Properties();

    public ElectronicsDAOImpl() throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
        proFile.load(is);
    }

    @Override
    public List<Electronics> selectAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Electronics> list = new ArrayList<Electronics>();
        String sql = proFile.getProperty("query.select");
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Electronics e = new Electronics(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9) );
                list.add(e);
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return list;
    }

    @Override
    public List<Electronics> getBoardList(int pageNo) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Electronics> list = new ArrayList<Electronics>();
        String sql = proFile.getProperty("query.pagingSelect");

        try {
            con = DbUtil.getConnection();
            con.setAutoCommit(false); //자동 커밋 해제

            int totalCount = this.getTotalCount(con); //전체 게시물 수 저장

            //전체 페이지 수
            int totalPage = totalCount%pageNo==0 ? totalCount/ PageCnt.pagesize : totalCount/PageCnt.pagesize+1;

            PageCnt pageCnt = new PageCnt();
            pageCnt.setPageCnt(totalPage);
            pageCnt.setPageNo(pageNo);

            ps = con.prepareStatement(sql);

            ps.setInt(1, (pageNo-1)*pageCnt.pagesize+1); //시작
            ps.setInt(2, pageNo*pageCnt.pagesize); //끝
            rs = ps.executeQuery();

            while (rs.next()) {
                Electronics e = new Electronics(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9) );
                list.add(e);
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return list;
    }

    private int getTotalCount(Connection con) {
        return 0;
    }

    @Override
    public Electronics selectByModelNum(String modelNum) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Electronics e = null;
        String sql = proFile.getProperty("query.selectBymodelNum");

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, modelNum);
            rs = ps.executeQuery();
            while (rs.next()) {
                e = new Electronics(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9) );
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return e;
    }

    @Override
    public int increamentByReadnum(String modelNum) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql = proFile.getProperty("query.updateReadnum");
        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, modelNum);
            result = ps.executeUpdate();
        }finally {
            DbUtil.dbClose(con, ps);
        }
        return result;
    }

    @Override
    public int insert(Electronics electronics) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql = proFile.getProperty("query.insert");
        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, electronics.getModelNum());
            ps.setString(2, electronics.getModelName());
            ps.setInt(3, electronics.getPrice());
            ps.setString(4, electronics.getDescription());
            ps.setString(5, electronics.getPassword());
            ps.setString(6, electronics.getFname());
            ps.setInt(7, electronics.getFsize());
            result = ps.executeUpdate();
        }finally {
            DbUtil.dbClose(con, ps);
        }
        return result;
    }

    @Override
    public int delete(String modelNum, String password) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql = proFile.getProperty("query.delete");

        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, modelNum);
            ps.setString(2, password);
            result = ps.executeUpdate();
        }finally {
            DbUtil.dbClose(con, ps);
        }
        return result;
    }

    @Override
    public int update(Electronics electronics) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql = proFile.getProperty("query.update");

        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, electronics.getModelName());
            ps.setInt(2, electronics.getPrice());
            ps.setString(3, electronics.getDescription());
            ps.setString(4, electronics.getModelNum());
            ps.setString(5, electronics.getPassword());
            result = ps.executeUpdate();
        }finally {
            DbUtil.dbClose(con, ps);
        }
        return result;
    }
}
