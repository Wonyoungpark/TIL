package ex0206.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentServiceImpl implements StudentService {
	
	private ArrayList<Student> list = new ArrayList<Student>();
	
	/**
	 * 초기치 데이터 5명의 정보를 저장
	 * */
	public StudentServiceImpl() {
		list.add(new Student("A01", "희정", 20, "서울"));
		list.add(new Student("A02", "나영", 25, "대구"));
		list.add(new Student("A03", "효리", 22, "부산"));
		list.add(new Student("A04", "민아", 21, "경기"));
		list.add(new Student("A05", "선경", 20, "서울"));
	}

	@Override
	public boolean insert(Student st) {
        return list.add(st);
    }

	@Override
	public List<Student> selectAll() {
		return list;
	}

	@Override
	public Student selectBySno(String sno) {
		for(Student s:list) {
			if(s.getSno().equals(sno)) return s;
		}
		return null;
	}

	@Override
	public boolean delete(String sno) {
		for(Student s: list){
			if(s.getSno().equals(sno)) return list.remove(s);
		}
		return false;
	}

	@Override
	public boolean update(Student student) {
		for(Student s:list){
			if(s.getSno().equals(student.getSno())){
				Student s1 = selectBySno(student.getSno());
				s1.setAge(student.getAge());
				s1.setAddr(student.getAddr());
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Student> sortByAge() {
		List<Student> stulist = new ArrayList<>(list);
		Collections.sort(stulist);
		return stulist;
	}


}
