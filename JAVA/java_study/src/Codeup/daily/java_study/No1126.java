package Codeup.daily.java_study;

import java.util.Scanner;

public class No1126 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.printf("%d + %d = %d\n", a,b, a+b);
		System.out.printf("%d - %d = %d\n", a,b, a-b);
		System.out.printf("%d * %d = %d\n", a,b, a*b);
		System.out.printf("%d / %d = %d\n", a,b, a/b);
		System.out.printf("%d %% %d = %d", a,b, a%b);
	}

}
