package baekjoon;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class No10798 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		
//	}
//}

import java.util.Scanner;

public class No10798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[5][15];
		int[] lenarr = new int[5];
		int max = 0;
		
		for(int i=0;i<5;i++) {
			arr[i] = sc.next().toCharArray();
			lenarr[i] = arr[i].length;
			max = Math.max(max, lenarr[i]);
		}
		
		for(int i=0;i<max;i++) {
			for(int j=0;j<5;j++) {
				if(lenarr[j]>i) System.out.print(arr[j][i]);
			}
		}
	}
}
