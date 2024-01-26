package ex0126.hw;

public class Lotto {
	
	public static void checkDis(int[] lotto, int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(lotto[i]==lotto[j]) lotto[j]= (int)(Math.random()*45+1);
			}
		}
	}
	
	public static void sortDesc(int[] lotto, int n) {
		for(int i=0;i<lotto.length-1;i++) {
			for(int j=0;j<lotto.length-1;j++) {
				if(lotto[j]<lotto[j+1]) Sort.switchTwo(lotto,j+1,j);
			}
		}
	}
	
	public static void printL(int[] lotto, int n) {
		System.out.println(java.util.Arrays.toString(lotto));
	}

	public static void main(String[] args) {
		int n = 6;
		int[] lotto = new int[n];
		for(int i=0;i<n;i++) {
			lotto[i]= (int)(Math.random()*45+1);
		}
		checkDis(lotto, n);
		sortDesc(lotto, n);
		printL(lotto, n);
	}

}
