package codeup;

import java.util.Scanner;

public class No1072 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		
		for (int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

}
// 참고 사이트 : https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=monsik&logNo=221554496289