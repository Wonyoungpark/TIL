package org.opentutorials.javatutorials.polymorphism;

interface I{}
class C implements I{} // 클래스 C가 인터페이스 I를 구현하고 있음

public class PolymorphismDemo2 {

	public static void main(String[] args) {
		I obj = new C();
	}

}
