package Codeup.daily.java_study;

import java.util.Scanner;

public class No1097 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[19][19];
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int j=0;j<19;j++) {
				if (arr[x-1][j]==0) arr[x-1][j]=1;
				else arr[x-1][j]=0;
			}
			for(int j=0;j<19;j++) {
				if(arr[j][y-1]==0) arr[j][y-1]=1;
				else arr[j][y-1]=0;
			}
		}
		
		for(int i=0;i<19;i++) {
			for(int j=0; j<19;j++) {
				System.out.printf("%d ", arr[i][j]);
			}
			System.out.print("\n");
		}
	}

}
