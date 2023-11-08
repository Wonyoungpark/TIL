package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1045 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num[] = br.readLine().split(" ");
		long a = Integer.parseInt(num[0]);
		long b = Integer.parseInt(num[1]);
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);
		System.out.printf("%.2f",(double)a/b);
	}

}
