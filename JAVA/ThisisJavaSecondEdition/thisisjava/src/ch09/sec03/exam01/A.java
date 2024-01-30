package ch09.sec03.exam01;

public class A {
	//Nested Class
	static class B{
		void methodB() {System.out.println("methodB 실행");}
	}
	
	//Field
	B field1 = new B(); //인스턴스필드값으로 B 객체 대입
	static B field2 = new B(); //정적 필드 값으로 B객체 대입
	
	//Constructor
	A(){
		B field1 = new B();
	}
	
	//Method
	// method1은 class B에 static이 붙든 말든 상관이 없음
	//method1은 A객체가 있어야 실행되기 때문에 A에 B가 있다고 가정
	void method1() { //인스턴스 메소드
		B field1 = new B();
	}
	
	//method2는 class B에 static이 없으면, A객체가 있어야만 실행될 수 있는 코드를 작성하면 안됨
	static void method2() { //정적 메소드
		B field1 = new B();
	}
}
