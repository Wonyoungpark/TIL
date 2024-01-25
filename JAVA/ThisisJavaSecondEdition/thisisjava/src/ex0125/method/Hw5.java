package ex0125.method;

import java.util.Scanner;

public class Hw5 {
	public void Calc(int a, int b, String op) {
		if(op.equals("+")) System.out.println(a+b);
		else if (op.equals("-")) System.out.println(a-b);
		else if(op.equals("*"))	System.out.println(a*b);
		else if (op.equals("/")) System.out.println(a/b);
		else System.out.println("연산기호가 잘못 되었습니다.");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Hw4 h4 = new Hw4();
		
		while(true) {
			System.out.println("1.더하기 2.빼기 3.곱하기 4.나누기 9.종료");
			int n = sc.nextInt();
			if (n==9) System.exit(0);
			
			System.out.println("2개의 정수를 입력하세요.");
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(n==1) {
				h4.Calc(a,b,"+");
			} else if(n==2) {
				h4.Calc(a,b,"-");
			} else if(n==3) {
				h4.Calc(a,b,"*");
			} else if(n==4) {
				h4.Calc(a,b,"/");
			}
		}
	}

}
