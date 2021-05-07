package org.opentutorials.javatutorials.object;

class Calculator {
	int left, right;
	
	public void setOprands(int left, int right) {
		this.left = left; // this == 밑에서 선언한 c1(위에서 선언한 int left) // 오른쪽 left == 매개변수 int left
		this.right = right;
	}
	
	public void sum() {
		System.out.println(this.left + this.right);
	}
	
	public void avg() {
		System.out.println((this.left + this.right) / 2);
	}
}

public class CalculatorDemo4 {

	public static void main(String[] args) {
		Calculator c1 = new Calculator(); // 인스턴스 선언 -> 데이터타입을 만드는 것
		c1.setOprands(10, 20);
		c1.sum();
		c1.avg();
		
		Calculator c2 = new Calculator();
		c2.setOprands(20, 40);
		c2.sum();
		c2.avg();
	}

}
