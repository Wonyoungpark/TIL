package Codeup.daily.java_study;

import java.util.Scanner;

public class No1019 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String[] arr = a.split("\\.");
		
		int y = Integer.valueOf(arr[0]);
		int m = Integer.valueOf(arr[1]);
		int d = Integer.valueOf(arr[2]);
		System.out.printf("%04d.%02d.%02d", y,m,d);
	}
}