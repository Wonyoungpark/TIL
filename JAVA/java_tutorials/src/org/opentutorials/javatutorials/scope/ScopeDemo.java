package org.opentutorials.javatutorials.scope;

public class ScopeDemo {

	static void a() {
		int i = 0; // 이 i는 a() 안에서만 사용 가능
	}
	
	public static void main(String[] args) {
		for (int i=0; i<5; i++) { // i를 새로 선언 -> 지역변수
			a();
			System.out.println(i);
		}
	}

}
