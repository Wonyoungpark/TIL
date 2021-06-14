package daily.codeup.java_study;

import java.util.Scanner;

public class No1024 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String[] b = a.split("");
        for(int i=0;i<b.length;i++) {
        	System.out.printf("\'%s\'\n",b[i]);
        }
	}

}
