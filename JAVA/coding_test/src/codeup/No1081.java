package codeup;

import java.util.Scanner;

public class No1081 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int j = sc.nextInt();
		int a,b;
		
		for(a=1;a<=i;a++) {
			for(b=1;b<=j;b++) {
				System.out.printf("%d %d\n",a,b);
			}
		}

	}

}
