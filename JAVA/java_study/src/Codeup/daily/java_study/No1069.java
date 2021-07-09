package Codeup.daily.java_study;

import java.util.Scanner;

public class No1069 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
//		if (str=="A") {
//			System.out.println("best!!!");
//		} else if(str=="B") {
//			System.out.println("good!!");
//		} else if (str=="C") {
//			System.out.println("run!");
//		} else if(str =="D") {
//			System.out.println("slowly~");
//		} else {
//			System.out.println("what?");
//		}
		
		switch(str) {
		case "A":
			System.out.println("best!!!");
			break;
		case "B":
			System.out.println("good!!");
			break;
		case "C":
			System.out.println("run!");
			break;
		case "D":
			System.out.println("slowly~");
			break;
		default:
			System.out.println("what?");
		}
	}

}
