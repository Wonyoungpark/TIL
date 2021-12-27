package Baekjoon.daily.java_study;

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class No10818 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0;i<num;i++) {
			arr.add(sc.nextInt());
		}
		int maxi = Collections.max(arr);
		int mini = Collections.min(arr);
		System.out.printf("%d %d", mini,maxi);
	}

}
