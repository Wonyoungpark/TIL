package baekjoon;

import java.util.Scanner;

public class No2884 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		
		if (h>0 && m<45) {
			System.out.printf("%d %d", h-1,60-45+m);
		}
		else if(h>0 && m>=45) {
			System.out.printf("%d %d", h,m-45);
		}
		else if(h==0 && m<45) {
			System.out.printf("%d %d", 24-1,60-45+m);
		}
		else {
			System.out.printf("%d %d", h,m-45);
		}
	}

}
