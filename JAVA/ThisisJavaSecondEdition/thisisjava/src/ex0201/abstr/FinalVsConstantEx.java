package ex0201.abstr;

class Test {
	int age;
	final int ages=20; //final필드는 반드시 초기화(명시적 초기화/생성자 통한 초기화)
	
	
	final int age2;
	Test(int age2){
		this.age2=age2; //생성자를 이용한 final필드 초기화
	}
	
	
	static final int pie=20; //명시적 초기화
	//단, static은 생성자 통한 초기화 불가
	static final int pie2; // static 블럭에서 초기화 가능==constant==상수
	static {
		pie2=100;
	}
}

public class FinalVsConstantEx {

	public static void main(String[] args) {
//		Test t = new Test();
//		System.out.println("t.age = "+t.age);
//		t.age=30; //final필드는 값변경 불가
		
		
		
		Test t = new Test(20);
		System.out.println("t.age2="+t.age2);
		
		Test t2 = new Test(30);
		System.out.println("t2.age2="+t2.age2);
	}

}
