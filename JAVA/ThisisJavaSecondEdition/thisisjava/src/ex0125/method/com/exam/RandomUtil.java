package ex0125.method.com.exam;

import java.lang.Math;
import java.util.Random;

public class RandomUtil {
	public int getRandomInt1(int a, int b) {
		int rand = (int) (Math.random()*(b-a+1)+a);
		return rand;
	}
	
	public int getRandomInt2(int a, int b) {
		Random random = new Random();
		int rand = random.nextInt(b-a+1)+a;
		return rand;
	}
}
