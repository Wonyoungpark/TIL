package codeup;

import java.util.Scanner;

public class No1095 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mini=n;
		
		for(int i=0;i<n;i++) {
			int a = sc.nextInt();
			if(a<mini) mini=a;
		}
		System.out.print(mini);
	}

}
