package Codeup.daily.java_study;

import java.util.Scanner;

public class No1091 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long arr[] = new long[4];
		for(int i=0;i<4;i++) {
			arr[i] = sc.nextInt();
		}
		
		long a = arr[0];
		for(int i=1;i<arr[3];i++) {
			a = a*arr[1]+arr[2];
		}
		System.out.print(a);
	}

}
