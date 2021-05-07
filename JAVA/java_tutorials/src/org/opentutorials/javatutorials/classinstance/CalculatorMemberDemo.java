package org.opentutorials.javatutorials.classinstance;

class C1 {
	static int static_variable = 1;
	int instance_variable = 2;
	
	static void static_static() {
		System.out.println(static_variable); // 클래스 메소가 클래스변수에 접근
	}
	
	static void static_instance() {
//		System.out.println(instance_variable); //클래스 메소드에서 인스턴스변수에 접근 불가
	}
	
	void instance_static() {
		System.out.println(static_variable); // 인스턴스 메소드에서 클래스변수에 접근
	}
	
	void instance_instance() {
		System.out.println(instance_variable);
	}
}
public class CalculatorMemberDemo {

	public static void main(String[] args) {
		C1 c = new C1();
		c.static_static();
		c.static_instance();
		c.instance_static();
		c.instance_instance();
		
		C1.static_static(); // 클래스를 통해 클래스 메소드에 직접 접근
		C1.static_instance();
//		C1.instance_static(); // 클래스를 통해 인스턴스 메소드 직접 접근 불가
//		C1.instance_instance();
	}

}
