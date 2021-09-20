package Codeup.daily.java_study;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class N01084 {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String num[] = br.readLine().split(" ");
//		int r = Integer.parseInt(num[0]);
//		int g = Integer.parseInt(num[1]);
//		int b = Integer.parseInt(num[2]);
//		int cnt = 0;
//		
//		for(int i=0;i<r;i++) {
//			for(int j=0;j<g;j++) {
//				for(int k=0;k<b;k++) {
//					System.out.printf("%d %d %d\n",i,j,k);
//					cnt++;
//				}
//			}
//		}
//		System.out.println(cnt);
//	}
//
//}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N01084 {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
		try {
			String[] n = br.readLine().split(" ");
			int count = 0;
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for (int i = 0; i < Integer.valueOf(n[0]); i++) {
				for (int j = 0; j < Integer.valueOf(n[1]); j++) {
					for (int k = 0; k < Integer.valueOf(n[2]); k++) {
						bw.write(i + " " + j + " " + k + "\n");
						count++;
					}
				}
			}
			bw.write(String.valueOf(count));
			bw.flush(); // 남아있는 데이터 모두 출력
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

// 참고 사이트 : https://sowon-dev.github.io/2020/10/14/201015al-c1084/