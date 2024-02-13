package ex0213;

import java.io.FileInputStream;
import java.util.Scanner;

public class SystemSetInExam {

	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("src/ex0213/test.txt"));//파일 불러오기
		
		Scanner sc = new Scanner(System.in); //불러온 파일을 읽기
		while(sc.hasNext()) {
		   String data = sc.nextLine();
		   System.out.println(data);
		}

	}

}
