package Codeup.daily.java_study;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class No1090 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String arr[] = br.readLine().split(" ");
		
		long a = Integer.parseInt(arr[0]);
		long r = Integer.parseInt(arr[1]);
		long n = Integer.parseInt(arr[2]);
		
		System.out.print(a*(long)Math.pow(r,(n-1)));
	}

}
