package ex0130.constructor;

public class StudentService {
	private Student strArr[] = new Student[5];
	private int count;
	
	
	//초기 데이터 세팅
	public StudentService() {
		strArr[count++] = this.create("희희",33,"성남");
		strArr[count++] = this.create("용용",28,"강동");
		strArr[count++] = this.create("도도",18,"송파");
	}
	
	//객체 생성
	private Student create(String name,int age,String addr) {
		Student st = new Student(name,age,addr);
		return st;
	}
	
	//학생 정보 등록
	public void insert(Student st) {
		if (count<5){
//			strArr[count++] = this.create(st.getName(),st.getAge(),st.getAddr());
			strArr[count++] = st;
			System.out.println("등록되었습니다.");
		}
		else System.out.println("더 이상 추가할 수 없습니다.");
	}

	//전체 학생 조회
	public void selectAll() {
		System.out.println("전체 학생 정보 조회("+count+"명)");
		for(int i=0;i<count;i++) {
			System.out.println("이름:"+strArr[i].getName()+"\t");
			System.out.println("나이:"+strArr[i].getAge()+"\t");
			System.out.println("주소:"+strArr[i].getAddr()+"\t");
		}
	}
	
	//이름으로 학생 정보 찾기
	public void selectByName(String name) {
		for(Student st:strArr) {
			if (name.equals(st.getName())) {
				System.out.println(st.getName());
				System.out.println(st.getAge());
				System.out.println(st.getAddr());
				return;
			}
		}
		System.out.println("찾는 정보가 없습니다.");
	}
	
	//이름으로 학생의 주소 정보 변경
	public void update(Student student) {
		for(Student st:strArr) {
			if(st.getName().equals(student.getName())) {
				st.setAddr(student.getAddr());
				System.out.println("수정되었습니다.");
				return;
			}
		} System.out.println("수정할 수 없습니다.");
	}

}
