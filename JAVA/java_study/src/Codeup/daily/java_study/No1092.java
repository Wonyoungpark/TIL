package Codeup.daily.java_study;

import java.util.Scanner;

public class No1092 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[3];
		for(int i=0;i<3;i++) arr[i]=sc.nextInt();
		
		int day=1;
		while(day%arr[0]!=0 || day%arr[1]!=0 || day%arr[2]!=0) day++;
		System.out.printf("%d", day);
	}

}
