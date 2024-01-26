package ex0126.hw;

public class Exrcise07 {

	public static void main(String[] args) {
		int max = 0;
		int[] array = {1,5,3,8,2};
		
		for(int a: array) {
			if (a>max) max=a;
		}
		System.out.println("max: "+max);
	}

}
