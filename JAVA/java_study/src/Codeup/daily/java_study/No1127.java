package Codeup.daily.java_study;

import java.util.Scanner;

public class No1127 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float rate,score;
		float averg = 0;
		
		for(int i=0;i<3;i++) {
			rate = sc.nextFloat();
			score = sc.nextFloat();
			averg += rate*score;
		}
		System.out.printf("%.1f", averg);
	}

}
