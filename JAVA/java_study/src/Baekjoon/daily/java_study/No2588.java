package Baekjoon.daily.java_study;

import java.util.Scanner;

public class No2588 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        String b = sc.next();
//        int seq = 1;
//        int total = 0;
//        
//        for (int i = b.length() -1; i>=0; i--) {
//        	int r = b.charAt(i)*a;
//        	System.out.println(r);
//        	total += seq*r;
//        	seq *=10;
//         }
//        System.out.println(total);
        
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(a*(b%10));
		System.out.println(a*((b%100)/10));
		System.out.println(a*(b/100));
		System.out.println(a*b);
	}

}
