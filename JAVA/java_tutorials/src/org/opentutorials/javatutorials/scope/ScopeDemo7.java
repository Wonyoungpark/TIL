package org.opentutorials.javatutorials.scope;

class C {
	int v = 10; // 전역변수
	
	void m() {
		int v = 20; // 지역변수
		System.out.println(v); // 지역변수 출력
		System.out.println(this.v); // 전역변수 출력
	}
}

public class ScopeDemo7 {

	public static void main(String[] args) {
		C c1 = new C();
		c1.m();
	}

}
