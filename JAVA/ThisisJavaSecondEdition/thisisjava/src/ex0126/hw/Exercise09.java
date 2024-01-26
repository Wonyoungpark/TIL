package ex0126.hw;

import java.util.Scanner;

public class Exercise09 {

	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("--------------------------");
			System.out.println("1.학생수 2.점수입력 3.점수리스트 4.분석 5.종료");
			System.out.println("--------------------------");
			System.out.print("선택>");
			
			int n = sc.nextInt();
			if (n==1) {
				System.out.print("학생수 입력 >");
				studentNum = sc.nextInt();
				scores = new int[studentNum];
			} else if(n==2) {
				for(int i=0;i<studentNum;i++) {
					System.out.printf("scores[%d] >",i);
					int score = sc.nextInt();
					scores[i]=score;
				}
			} else if (n==3) {
				for(int i=0;i<studentNum;i++) {
					System.out.printf("scores[%d]: %d%n",i,scores[i]);
				}
			} else if(n==4) {
				int max = 0;
				double sum = 0;
				
				for(int s: scores) {
					if (s>max) max=s;
					sum+=s;
				}
				System.out.println("최고점수: "+max);
				System.out.printf("평균점수: %.1f\n",sum/studentNum);
			} else if(n==5) run = false;
		}
		System.out.println("시스템 종료");
	}

}
