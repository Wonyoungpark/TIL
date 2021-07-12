package Codeup.daily.java_study;

import java.util.Scanner;

public class No1078 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int answer = 0;
		for(int i=0;i<=a;i+=2) {
			answer += i;
		}
		System.out.println(answer);
	}

}
