package Codeup.daily.java_study;

import java.util.Scanner;

public class No1027 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.next().split("\\.");
		String day="";
		
		for (int i= arr.length; i>0;i--) {
			if (i != 1) {
				day = day + (arr[i-1]+"-");
			}
			else {
				day = day + (arr[i-1]);
			}
		}
		System.out.println(day);
	}

}
