package ex0125.method;

import java.util.Scanner;

public class HomeWork {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int bank = 0;
		while(true) {
			System.out.println("----------------------------");
			System.out.println("1. 예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------");
			System.out.print("선택> ");
			int n = sc.nextInt();
			if (n==1) {
				System.out.print("예금액> ");
				int cash = sc.nextInt();
				bank+=cash;
			} else if (n==2) {
				System.out.print("금액> ");
				int cash = sc.nextInt();
				bank-=cash;
			} else if (n==3) {
				System.out.println("잔고> "+bank);
			} else {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
}
