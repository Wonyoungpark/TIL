package service;

import dao.ElectronicsDAO;
import dao.ElectronicsDAOImpl;
import dto.Electronics;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ElectronicsServiceImpl implements ElectronicsService {
    ElectronicsDAO electronicsDAO = new ElectronicsDAOImpl();

    public ElectronicsServiceImpl() throws IOException {}

    @Override
    public List<Electronics> selectAll() throws SQLException {
        return electronicsDAO.selectAll();
    }

    @Override
    public List<Electronics> selectAll(int pageNo) throws SQLException {
        return List.of();
    }

    @Override
    public void insert(Electronics electronics) throws SQLException {

        int result = electronicsDAO.insert(electronics);
        if (result == 0) throw new SQLException("정보 등록을 실패했습니다.");
    }

    @Override
    public Electronics selectByModelnum(String modelNum, boolean flag) throws SQLException {
        Electronics electronics;
        electronics = electronicsDAO.selectByModelNum(modelNum);
        if(electronics==null) throw new SQLException("해당 모델 번호에 해당하는 정보가 없습니다.");

        if(flag) electronicsDAO.increamentByReadnum(modelNum);
        return electronics;
    }

    @Override
    public void delete(String modelNum, String password, String saveDir) throws SQLException {
        int result = electronicsDAO.delete(modelNum, password);
        if (result==0) throw new SQLException("삭제를 실패하였습니다.");
    }

    @Override
    public void update(Electronics electronics) throws SQLException {
        int result = electronicsDAO.update(electronics);
        if (result==0) throw new SQLException("수정을 실패하였습니다.");
    }
}
