package ch09.sec02.exam01;

public class A {
	//Field
	int field; // static이 없기 때문에 field는  인스턴스멤버
	B field2;
	
	//Constructor
	A() {
		B b = new B(); //A클래스 안이기 때문에 A.B라고 명시하지 않아도 됨
		b.methodB();
	}
	
	//Method
	void methodA() { //인스턴스 메소드
		B b = new B();
		b.methodB();
	}
	
	//Nested Class : 위치 상관 X
	public class B {
		//Field
		//Constructor
		//Method
		void methodB() { //public 없어도 됨
			System.out.println("methodB() 실행");
		}
	}
}
