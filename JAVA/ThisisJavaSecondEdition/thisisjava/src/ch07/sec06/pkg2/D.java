package ch07.sec06.pkg2;

import ch07.sec06.pkg1.A;

public class D extends A {
	//상속
	public D() {
		super(); //A생성자 호출
	}
	//상속
	public void method1() {
		this.field = "value"; //A필드값 변경
		this.method(); //A 메소드 호출
	}
	
	//import -> 직접 객체 생성 부락
	
	public void method2() {
//		A a = new A();
//		a.field = "vallue";
//		a.method();
	}
}
