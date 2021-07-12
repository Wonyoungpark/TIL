package Codeup.daily.java_study;

import java.util.Scanner;

public class No1076 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char a = sc.next().charAt(0);
		char b = 'a';
		
		while(a>=b) {
			System.out.printf("%c ",b);
			b+=1;
		}
	}

}

// 참고 사이트 : https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=monsik&logNo=221554589172