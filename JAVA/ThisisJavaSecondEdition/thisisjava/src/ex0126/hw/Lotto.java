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
		for(int i=0;i<n;i++) {
			
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
		checkDis(lotto, n);
		printL(lotto, n);
	}

}
