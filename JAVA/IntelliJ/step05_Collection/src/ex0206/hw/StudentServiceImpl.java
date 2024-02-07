package ex0206.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

//		for(Student s: list){
//			if(s.getSno().equals(sno)) return list.remove(s);
//		}
//		return false;

		Student student = this.selectBySno(sno);
		return list.remove(student);
	}

	@Override
	public boolean update(Student student) {
//		for(Student s:list){
//			if(s.getSno().equals(student.getSno())){
//				Student s1 = selectBySno(student.getSno());
//				s1.setAge(student.getAge());
//				s1.setAddr(student.getAddr());
//				return true;
//			}
//		}
//		return false;

		Student searchStudent = this.selectBySno(student.getSno());
		if(searchStudent==null) return false;
		searchStudent.setAge(student.getAge());
		searchStudent.setAddr(student.getAddr());
		return true;
	}

	@Override
	public List<Student> sortByAge() {
		List<Student> stulist = new ArrayList<>(list);

		Collections.sort(stulist);

//		//Comparator 사용
//		Collections.sort(stulist, new SortComparatorTest());
		//but, 일회성 사용일 경우, 따로 클래스 생성을 권장하지 않음

//		//익명클래스를 사용해서 Comparator 구현
//		Collections.sort(stulist, new Comparator<Student>() {
//			@Override
//			public int compare(Student o1, Student o2) {
//				return o1.getAge()-o2.getAge();
//			}
//		});

		return stulist;
	}
}

//Comparator 구현 객체
class SortComparatorTest implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getAge()-o2.getAge();
	}
}