package codeup;

import java.util.Scanner;

public class No1080 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = 0;
		int c = 0;
		
		while (a > c) {
			b++;
			c += b;
		}
		System.out.println(b);
	}

}
