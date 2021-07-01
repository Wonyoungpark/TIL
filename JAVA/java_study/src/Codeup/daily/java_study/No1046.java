package Codeup.daily.java_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1046 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num[] = br.readLine().split(" ");
		long a = Integer.parseInt(num[0]);
		long b = Integer.parseInt(num[1]);
		long c = Integer.parseInt(num[2]);
		
		System.out.println(a+b+c);
		System.out.printf("%.1f",(double)(a+b+c)/3);
	}

}
