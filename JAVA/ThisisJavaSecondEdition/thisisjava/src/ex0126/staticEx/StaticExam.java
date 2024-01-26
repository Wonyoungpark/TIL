package ex0126.staticEx;

class Test {
	int i = 10; //인스턴스 필드(객체 생성 시 생성)
	static int j=5; //static 필드(객체 생성과 무관하게 하드웨어에 클래스가 로더될때 자동으로 메모리 생성)
	
	public void aa() { //non-static 메소드 내에서는 static&non-static 모두 접근 가능
		System.out.println(i);
		System.out.println(this.i);
		
		System.out.println(j);
		System.out.println(this.j);
		System.out.println(Test.j);
	}
	
	public void bb() {
		//메소드 호출
		aa();
		this.aa();
		
		cc();
		this.cc();
		Test.cc();
	}
	
	public static void cc() {
//		System.out.println(i); //static 메소드 내에서 non-static 접근 불가
//		System.out.println(this.i); //this 사용 불가
		
		System.out.println(j);
//		System.out.println(this.j); //this 사용 불가
		System.out.println(Test.j);
	}
	
	public static void dd() {
		//메소드 호출
//		aa();
//		this.aa();
		
		cc();
//		this.cc();
		Test.cc();
	}
}

public class StaticExam {

	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2= new Test();
		Test t3 = new Test();

		System.out.println("주소값 t1:"+t1);
		System.out.println("주소값 t2:"+t2);
		System.out.println("주소값 t3:"+t3);
		
		
		System.out.println("인스턴스 필드 접근");
		System.out.println("t1.i"+t1.i);
		System.out.println("t2.i"+t2.i);
		System.out.println("t3.i"+t3.i);
		
		//값 변경
		t1.i=50;
		System.out.println("값 변경 후");
		System.out.println("t1.i"+t1.i);
		System.out.println("t2.i"+t2.i);
		System.out.println("t3.i"+t3.i);
		
		

		System.out.println("t1.i"+t1.j);
		System.out.println("t2.i"+t2.j);
		System.out.println("t3.i"+t3.j);
		// static은 객체 생성 없이 사용하는 게 나음
	}
	
	//static : 초기화 작업, 환경설정 세팅, 초기 데이터 로딩
	//static의 위치 : main()이 포함된 클래스 중 상관 없음
	static {
		System.out.println("static runs faster than main()");
	}
}
