package ex0130.constructor;

public class StudentTest {
	public static void main(String[] args) {
		System.out.println("=학생관리 프로그램을 시작합니다.=");
		StudentService service = new StudentService();
		
		service.selectAll();
		
		System.out.println("=등록하기=");
		Student student = new Student("미미",20,"오리역");
		service.insert(student);
		
		System.out.println("=이름으로 검색=");
		service.selectByName("미미");
		
		System.out.println("=수정하기=");
		Student st2 = new Student("미미","대전");
		service.update(st2);
		
		service.selectAll();
	}
}
