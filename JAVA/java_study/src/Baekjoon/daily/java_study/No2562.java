package Baekjoon.daily.java_study;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class No2562 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0;i<9;i++) {
			arr.add(sc.nextInt());
		}
		int maxi = Collections.max(arr);
		System.out.println(maxi);
		System.out.println(arr.indexOf(maxi)+1);
	}

}
