package Baekjoon.daily.java_study;

import java.util.Scanner;
import java.util.ArrayList;

public class No3052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0;i<10;i++) {
			int n = sc.nextInt()%42;
			if (!arr.contains(n)) arr.add(n);
		}
		System.out.println(arr.size());
	}

}
