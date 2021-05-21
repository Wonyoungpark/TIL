package org.opentutorials.javatutorials.abstarctclass.example3;

abstract class Calculator {
	int left, right;
	
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}
	int _sum() {
		return this.left + this.right;
	}
	
	public abstract void sum(); // 사용자가 직접 디자인해야하는 경우 abstract 사용
	public abstract void avg();
	
	public void run() { // 메서드를 호출 순서 정의
		sum();
		avg();
	}
}

class CalculatorDecoPlus extends Calculator {
	public void sum() {
		System.out.println("+ sum :" +_sum());
	}
	public void avg() {
		System.out.println("+ avg :" +(this.left+this.right)/2);
	}
}

class CalculatorDecoMinus extends Calculator {
	public void sum() {
		System.out.println("- sum :" +_sum());
	}
	public void avg() {
		System.out.println("- avg :" +(this.left+this.right)/2);
	}
}

public class CalculatorDemo {

	public static void main(String[] args) {
		CalculatorDecoPlus c1 = new CalculatorDecoPlus();
		c1.setOprands(10, 20);
		c1.run();
		
		CalculatorDecoMinus c2 = new CalculatorDecoMinus();
		c2.setOprands(10, 20);
		c2.run();
	}

}
