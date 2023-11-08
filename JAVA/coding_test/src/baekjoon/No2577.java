package baekjoon;

import java.util.Scanner;

public class No2577 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 1;
		for(int i=0;i<3;i++) num *= sc.nextInt();
		String nums = Integer.toString(num);
		String[] sarr = nums.split("");
		int[] arr = new int[10];
		
		for(String n : sarr) arr[Integer.parseInt(n)] ++;
		for(int a : arr) System.out.println(a);
	}

}
