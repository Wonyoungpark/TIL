package ex0124.control;

public class ForExam01 {

	public static void main(String[] args) {
		for(int i=1;i<101;i++) System.out.print(i);
		for(char i='A';i<='Z';i++) System.out.print(i);
		
		int sum=0;
		for(int i=1;i<=10;i++) sum+=1;
		
		for(int i=1;i<=100;i++) {
			if (i%7==0) System.out.print(i);
		}
		
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) System.out.print(i+j);
			System.out.println();
		}
	}

}
