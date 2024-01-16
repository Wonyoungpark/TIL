package ch02.sec13;

import java.util.Scanner;


public class ScannerExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("x값 입력 : ");
		String strX = sc.nextLine();
		System.out.println(strX);
		int x = Integer.parseInt(strX);
		
		System.out.println("y값 입력 : ");
		String strY = sc.nextLine();
		int y = Integer.parseInt(strY);
		
		int result = x+y;
		System.out.println("x+y : "+result);
		
		while(true) {
			System.out.println("입력문자열: ");
			String data = sc.nextLine();
			if(data.equals("q")) {
				break;
			}
			System.out.println("출력 문자열: "+data);
			System.out.println();
		}
		System.out.println("종료");
	}
}
