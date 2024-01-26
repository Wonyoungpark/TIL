package ch06.sec10.exam01;

public class CalculatorExample {
	public static void main(String[] args) {
//		static 요소는 객체를 생성하지 않음!
//		Calculator calc = new Calculator();
//		double res = 10*calc.pi;
//		int res2 = calc.plus(0, 0);
//		int res3 = calc.minus(2, res2);
		
		double result = 10*10*Calculator.pi;
		int result2 = Calculator.plus(1,2);
		int result3 = Calculator.minus(4, 3);
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
	}
}
