package baekjoon;

import java.util.Scanner;
import java.util.Arrays;

public class No10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		String abc = "abcdefghijklmnopqrstuwvxyz";
		int[] idx = new int[26];
		Arrays.fill(idx, -1);
		
		for(char c : word.toCharArray()) idx[abc.indexOf(c)] = word.indexOf(c);
		
		for(int i=0;i<26;i++) System.out.print(idx[i]+" ");
	}
}