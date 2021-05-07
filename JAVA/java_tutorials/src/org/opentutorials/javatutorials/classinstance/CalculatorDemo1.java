package org.opentutorials.javatutorials.classinstance;

class Calculatorr {
	static double PI = 3.14; // 클래스 전체에서 사용 가능
	int left, right;
	
	public void setOprands(int left, int right) { // left와 right는 지역변수
		this.left = left; // 전역변수에 지역변수 할당
		this.right = right;
	}
//	public void setOprands(int _left, int _right) {
//		left = _left;
//		right = _right;
//	}
	
	public void sum() {
		System.out.println(this.left + this.right);
	}
	
	public void avg() {
		System.out.println((this.left + this.right) / 2);
	}
}
public class CalculatorDemo1 {

	public static void main(String[] args) {
		Calculatorr c1 = new Calculatorr();
		System.out.println(c1.PI); // 인스턴스를 통해 접근
		
		Calculatorr c2 = new Calculatorr();
		System.out.println(c2.PI);
		
		System.out.println(Calculatorr.PI); // 클래스를 통해 직접적으로 접근
	}

}
