package java_codingtest;

import java.util.Scanner;

public class No4 {
	static int[] arr = {5,10,15,19,23,30,47,56,78,80};
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		System.out.println(BSTree(target,0,arr.length-1));
	}
	
	static int BSTree(int target, int low, int high) {
		int mid;
		
		while (low<=high) {
			mid = (low+high)/2;
			if (target==arr[mid]) {
				return mid;
			} else if (target<arr[mid]) {
				high = mid-1;
			} else {
				low = mid +1;
			}
		}
		return -1;
	}

}
