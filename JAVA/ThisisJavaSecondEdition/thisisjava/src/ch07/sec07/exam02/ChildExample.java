package ch07.sec07.exam02;

public class ChildExample {

	public static void main(String[] args) {
		Child child = new Child();
		
		//자동 타입변환
		Parent parent = child;
		
		parent.method1();
		parent.method2();
//		parent.method3(); //사용 불가
	}

}
