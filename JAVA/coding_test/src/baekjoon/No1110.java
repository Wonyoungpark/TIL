package baekjoon;

import java.util.Scanner;

public class No1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		sc.close();
		int cnt = 0;
		int copy = a;
		
		while(true) {
			a = ((a%10)*10)+(((a/10)+(a%10))%10);
			cnt++;
			if (copy ==a) break;
		}
		System.out.println(cnt);
	}

}

// 참고 사이트 : https://st-lab.tistory.com/42