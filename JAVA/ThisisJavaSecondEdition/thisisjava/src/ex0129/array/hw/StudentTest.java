package ex0129.array.hw;

public class StudentTest {
	public static void main(String[] args) {
		System.out.println("=학생관리 프로그램을 시작합니다.=");
		StudentService service = new StudentService();
		service.init();
		
		service.selectAll();
		
		System.out.println("=등록하기=");
		Student student = new Student();
		student.setName("미미");
		student.setAge(20);
		student.setAddr("오리역");
		service.insert(student);
		
		System.out.println("=이름으로 검색=");
		service.selectByName("미미");
		
		System.out.println("=수정하기=");
		service.update("원영");
		
		service.selectAll();
	}
}
