package baekjoon;

import java.util.Scanner;

public class No8393 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int total = 0;
		for(int i=1;i<(a+1);i++) {
			total += i;
		}
		System.out.print(total);
	}

}
