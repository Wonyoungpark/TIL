package codeup;

import java.util.Scanner;

public class No1086 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double storage = 1;
		for(int i=0;i<3;i++) {
			storage *= sc.nextDouble();
		}
		System.out.printf("%.2f MB",storage/Math.pow(2, 23));
	}

}
