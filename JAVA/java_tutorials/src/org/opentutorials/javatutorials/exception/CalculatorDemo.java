package org.opentutorials.javatutorials.exception;

class Calculator{
	int left, right;
	
	public void setOprands(int left, int right) {
//		if (right == 0) {
//			throw new IllegalArgumentException("두번째 인자는 0을 혀용하지 않습니다.");
//		}
		this.left = left;
		this.right = right;
	}
	public void divide() {
		if (right == 0) {
			throw new ArithmeticException("0으로 나눌 수 없습니다.");
		}
		try { // 예외 처리
			System.out.print("계산결과는 ");
			System.out.print(this.left/this.right);
			System.out.print(" 입니다.");
		} catch(Exception e) {
			System.out.println("\n\ne.getMessage()\n"+e.getMessage());
			System.out.println("\n\ne.toString()\n"+e.toString());
			System.out.println("\n\ne.printStackTrace()\n");
			e.printStackTrace();
		}
		System.out.println("Divide End");
	}
}
public class CalculatorDemo {

	public static void main(String[] args) {
		Calculator c1 = new Calculator();
		c1.setOprands(10, 0);
		try {
			c1.divide();
		} catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}

}
