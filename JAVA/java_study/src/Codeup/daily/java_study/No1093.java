package Codeup.daily.java_study;

import java.util.Scanner;

public class No1093 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int arr[] = new int[23];

		for(int i=0;i<a;i++) {
			int c = sc.nextInt();
			arr[c-1]++;
		}
		
		for(int i=0;i<23;i++) {
			System.out.printf("%d ",arr[i]);
		}
	}

}
