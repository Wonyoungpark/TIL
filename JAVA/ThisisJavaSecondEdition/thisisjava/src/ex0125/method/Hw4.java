package ex0125.method;

import java.util.Scanner;

public class Hw4 {
	public void Calc(int a, int b, String op) {
		if(op.equals("+")) System.out.println(a+b);
		else if (op.equals("-")) System.out.println(a-b);
		else if(op.equals("*"))	System.out.println(a*b);
		else if (op.equals("/")) System.out.println(a/b);
		else System.out.println("연산기호가 잘못 되었습니다.");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("2개의 정수와 1개의 연산기호를 입력하세요.");
		int a = sc.nextInt();
		int b = sc.nextInt();
		String op = sc.next();
		Hw4 h4 = new Hw4();
		h4.Calc(a,b,op);
	}

}
