package ex0206.exam06;

//과정 신청 클래스
public class Course {
	//모든 사람 등록
	public void register1(Applicant<?> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName()+"가 신청되었습니다.1");
	}
	
	//직장인만 등록
	public void register2(Applicant<? super Worker> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName()+"가 신청되었습니다.2");
	}

	//학생만 등록
	public void register3(Applicant<? extends Student> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName()+"가 신청되었습니다.3");
	}
}
