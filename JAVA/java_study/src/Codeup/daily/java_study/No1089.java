package Codeup.daily.java_study;

import java.util.Scanner;

public class No1089 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		for(int i=0;i<3;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.print(arr[0]+(arr[2]-1)*arr[1]);
	}

}
