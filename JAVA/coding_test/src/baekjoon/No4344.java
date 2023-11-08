package baekjoon;

import java.util.Scanner;

public class No4344 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			int k = sc.nextInt();
			int[] arr = new int[k];
			double mean = 0;
			double result = 0;
			for(int j=0;j<k;j++) {
				arr[j]=sc.nextInt();
				mean += arr[j];
			}
			mean /= k;
			for(int a: arr) {
				if(a>mean) result++;
			}
			System.out.printf("%.3f%%\n", result/k*100);
		}
	}

}
