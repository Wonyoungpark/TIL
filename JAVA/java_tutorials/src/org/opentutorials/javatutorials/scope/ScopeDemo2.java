package org.opentutorials.javatutorials.scope;

public class ScopeDemo2 {

	static int i; // i 선언 -> 전역변수
	
	static void a() {
		i = 0;
//		int i = 0; // -> 지역변수
	}
	
	public static void main(String[] args) {
		for (i=0; i<5; i++) {
			a();
			System.out.println(i);
		} // => 무한 루프
	}

}
