package ex0125.method.com.exam;

import java.util.Scanner;

public class RandomUtilTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		RandomUtil ru = new RandomUtil();
		System.out.println(ru.getRandomInt1(a,b));
		System.out.println(ru.getRandomInt2(a,b));
	}

}
