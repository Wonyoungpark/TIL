package db.view;

import db.dao.EmpDAO;
import db.dto.Emp;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println("***JDBC 연동***");
        EmpDAO dao = new EmpDAO();
//        dao.selectByName();

        System.out.println("2.전체 검색");
        List<Emp> list = dao.selectAll();
        for(Emp l:list) System.out.println(l); //l.toString();

        System.out.println("3.사원번호 검색");
        Emp emp = dao.selectByEmpno(7499);
//        Emp emp = dao.selectByEmpno(9999);
        if(emp==null) System.out.println("찾는 정보가 없습니다.");
        else System.out.println(emp);

        System.out.println("4.사원 등록");
        int re = dao.insert(new Emp(9000,"king","student",200,null));
        if(re==0) System.out.println("등록 실패");
        else System.out.println("등록 완료");

        System.out.println("4-1.사원 등록");
        int pre = dao.prepareInsert(new Emp(9002,"pro","student",200,null));
        if(pre==0) System.out.println("등록 실패");
        else System.out.println("등록 완료");


    }
}
