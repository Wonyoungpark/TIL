package codeup;

import java.util.Arrays;
import java.util.Scanner;

public class No1124 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String state = sc.next();
		state = state.replace("C", "");
		String[] arr = state.split("H");
		int[] nums = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
		
		System.out.println(nums[0]*12+nums[1]);
	}

}
