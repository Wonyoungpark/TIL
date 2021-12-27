package Baekjoon.daily.java_study;

import java.util.Scanner;

public class No8958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			String[] arr = sc.next().split("");
			int cnt=0;
			int answer = 0;
			for(String a:arr) {
				if (a.equals("O")) cnt++;
				else  cnt=0;
				answer += cnt;
			}
			System.out.println(answer);
		}
	}

}
