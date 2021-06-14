package Codeup.daily.java_study;

import java.util.Scanner;

public class No1023 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String f = sc.next();
		String[] number = f.split("\\.");
		System.out.printf("%s\n%s",number[0],number[1]);
	}

}

// 참고 사이트 : https://javaprograming.tistory.com/21