package Baekjoon.daily.java_study;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class No1546 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0;i<n;i++) arr.add(sc.nextInt());
		int maxi = Collections.max(arr);
		
		double mean = arr.stream().mapToInt(Integer::intValue).sum();
		System.out.printf("%.2f", mean/maxi/n*100);
	}

}
