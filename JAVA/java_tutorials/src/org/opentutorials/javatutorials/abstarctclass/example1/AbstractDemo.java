package org.opentutorials.javatutorials.abstarctclass.example1;

abstract class A { // 멤버 중 하나라도 추상클래스면 추상 클래스로 정의
	public abstract int b();
//	public abstract int c() {
//		System.out.println("Hello");
//	}
	public void d() {
		System.out.println("world");
	}
}

class B extends A {
	public int b() { // overriding
		return 1;
	}
}

public class AbstractDemo {

	public static void main(String[] args) {
//		A obj = new A();
		B obj = new B();
	}

}
