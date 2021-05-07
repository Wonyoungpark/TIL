package org.opentutorials.javatutorials.classinstance;

class Calculator2 {
	static double PI = 3.14;
	static int base = 0; // 클래스 변수 : 인스턴스에 따라 값의 변경이 필요하지 않은 변수
	int left, right;
	
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	public void sum() {
		System.out.println(this.left + this.right + base);
	}
	
	public void avg() {
		System.out.println((this.left + this.right + base) / 2);
	}
}
public class CalculatorDemo2 {

	public static void main(String[] args) {
		Calculator2 c1 = new Calculator2();
		c1.setOprands(10,20);
		c1.sum();
		
		Calculator2 c2 = new Calculator2();
		c2.setOprands(20,40);
		c2.sum();
		
		Calculator2.base = 10; // 클래스변수 base값 변경
		c1.sum();
		c2.sum();
		
	}

}
