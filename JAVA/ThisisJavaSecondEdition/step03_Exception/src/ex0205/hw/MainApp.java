package ex0205.hw;

import java.util.Random;

public class MainApp {
	public static void main(String[] args) {
//		for(int i=0;i<10;i++) {
//			try {
//				int age = (int)(Math.random()*55)+1;
//				new ShoppingMall().getAge(age);
//			} catch(AgeException e) {
//				System.out.println(e.getMessage());
//			}
//		}
		
		ShoppingMall mall = new ShoppingMall();
		Random r = new Random();
		for(int i=0;i<10;i++) {
			int age = r.nextInt(55)+1;
			try {
				mall.getAge(age);
			} catch(AgeException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("예외 고객: "+AgeException.cnt+"명");
	}
}
