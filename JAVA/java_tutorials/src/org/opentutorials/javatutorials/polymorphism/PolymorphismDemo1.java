package org.opentutorials.javatutorials.polymorphism;

class A{
	public String x() {return "A.x";}
}

class B extends A{
	public String x() {return "B.x";}
	public String y() {return "y";}
}

class B2 extends A{
	public String x() {return "B2.x";}
}

public class PolymorphismDemo1 {

	public static void main(String[] args) {
		A obj = new B(); //클래스 B를 인스턴스화 시킨 obj를 A를 데이터 타입으로 갖는다.
		A obj2 = new B2();
		
		System.out.println(obj.x());
//		obj.y(); //A에 y가 존재하지 않음
		System.out.println(obj2.x());
	}

}
