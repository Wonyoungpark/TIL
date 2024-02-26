package db.view;

import db.dao.EmpDAO;

public class Test {
    public static void main(String[] args) {
        System.out.println("***JDBC 연동***");
        EmpDAO dao = new EmpDAO();
        dao.selectByName();
    }
}
