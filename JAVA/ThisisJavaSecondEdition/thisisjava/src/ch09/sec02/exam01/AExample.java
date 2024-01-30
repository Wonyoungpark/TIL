package ch09.sec02.exam01;

public class AExample {
	public static void main(String[] args) {
		A a = new A();
		a.field = 10;
		
//		A.B b= new A.B(); //이렇게 객체 생성 불가
		A.B b = a.new B(); //B는 A의 인스턴스클래스다
		b.methodB();
		
	}
}
