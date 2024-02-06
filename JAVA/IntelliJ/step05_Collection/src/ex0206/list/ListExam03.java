package ex0206.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExam03 {
    List<Emp> list = new ArrayList<>();

    public ListExam03(){
        //list에 사원 5명 추가
        list.add(new Emp(1,"name1",10,"addr1"));
        list.add(new Emp(5,"name5",50,"addr5"));
        list.add(new Emp(3,"name3",30,"addr1"));
        list.add(new Emp(7,"name7",70,"addr7"));
        list.add(new Emp(2,"name2",20,"addr2"));

        System.out.println(list);
        for(Emp e:list) System.out.println(e);
    } //생성자

    //이름으로 사원정보 검색 (이름 중복 불가)
    public Emp selectByName(String name){
        for(Emp e:list) {
            if(e.getEname().equals(name)) return e;
        }
        return null;
    }

    //주소에 해당하는 사원 정보 검색 (주소 중복 가능)
    public List<Emp> selectByAddr(String addr){
        List<Emp> searchList = new ArrayList<Emp>();

        for(Emp e:list) {
            if(e.getAddr().equals(addr)) searchList.add(e);
        }
        return searchList;
    }

    //사원번호를 기준으로 정렬 결과 리턴
    public List<Emp> sortByEmpno(){
        List<Emp> copyList = new ArrayList<Emp>(list); //list 복사
        Collections.sort(copyList); //Collections.sort()는 Comparable의 하위 클래스들만을 매개변수로 받기 때문에 Emp 구현 필요

        return copyList;
    }

    public static void main(String[] args){
        ListExam03 ex = new ListExam03();

        System.out.println("1. 이름으로 검색");
        Emp e = ex.selectByName("name3");
        System.out.println("e = "+e);

        System.out.println("2. 주소로 검색");
        List<Emp> searchList = ex.selectByAddr("addr1");
        if(searchList.isEmpty()) System.out.println("찾는 주소가 없습니다.");
        else {
            for(Emp emp:searchList) System.out.println(emp);
        }

        System.out.println("3. 정렬 연습");
        List<Emp> sortResult = ex.sortByEmpno();
        for(Emp emp:sortResult) System.out.println(emp);

    }
}
