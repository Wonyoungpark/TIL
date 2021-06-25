package Codeup.daily.java_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1025 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[]  = br.readLine().split("");
		int cnt = 5;
		
		for (String s: str) {
			cnt--;
			System.out.printf("["+s);
			for (int i = 0; i<cnt; i++) {
				System.out.printf("0");
			}
			System.out.printf("]\n");
		}
	}

}
