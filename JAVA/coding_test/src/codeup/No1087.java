package codeup;

import java.util.Scanner;

public class No1087 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int result = 0;
		int i = 0;
		
		do {
			result += i;
			i++;
		} while(result<num);
		
		System.out.println(result);
	}

}
