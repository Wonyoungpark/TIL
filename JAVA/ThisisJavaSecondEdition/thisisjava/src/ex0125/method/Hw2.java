package ex0125.method;

import java.util.Scanner;

public class Hw2 {
	private int GetTotal(int kor, int eng, int math) {
		return kor+eng+math;
	}
	
	private double GetAvg(int total, int n) {
		return total/n;
	}
	
	private String GetRank(double avg) {
		if (avg>=90) return "A";
		else if (avg>=80) return "B";
		else if (avg>=70) return "C";
		else return "F";
	}
	
	public void Print(String name, int kor, int eng, int math) {
		int total = this.GetTotal( kor, eng, math);
		System.out.println("총점: "+total);
		double avg = GetAvg(total, 3);
		System.out.println("평균: "+avg);
		String rank = GetRank( avg);
		System.out.println("등급: "+rank);
	}

	public static void main(String[] args) {
		Hw2 h2 = new Hw2();
		
		while(true) {
			System.out.println("1. 성적표구하기     2. 종료");
			Scanner sc = new Scanner(System.in);
			int p = sc.nextInt();
			if (p==1) {
				System.out.println("이름, 국어,영어,수학 점수 입력");
				String name = sc.next();
				int kor = sc.nextInt();
				int eng = sc.nextInt();
				int math = sc.nextInt();
				
				h2.Print(name, kor, eng, math);
			} else System.exit(0);
		}
	}
}
