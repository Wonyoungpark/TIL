package codeup;

import java.util.Scanner;

public class No1041 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char a = sc.next().charAt(0);
		int b = (int)a;
		char c = (char)(b+1);
		System.out.printf("%c", c);
	}

}
