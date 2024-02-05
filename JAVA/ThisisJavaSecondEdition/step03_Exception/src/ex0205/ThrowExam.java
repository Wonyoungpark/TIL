package ex0205;

import java.io.IOException;

public class ThrowExam {
	public void aa(int i) throws IOException,ArithmeticException {
		try {
			System.out.println("aa method call");
			//인수는 음수 금지 -> 예외 강제 발생
			if(i<0) {
				throw new IOException("음수 불가"); //체크 예외
	//			throw new RuntimeException("음수 불가"); //비체크 예외
			}
			System.out.println("양수 i = "+i);
			
			int result = 100/i; //0->ArithmeticException
		} finally {
			System.out.println("aa method end");
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("메인 시작--");
		try {
			new ThrowExam().aa(0);
		} catch(IOException | ArithmeticException e) {
			System.out.println("첫 예외 "+ e.getMessage());
		}
//		catch(ArithmeticException e) {System.out.println("두번째 예외"+e.getMessage());}
		System.out.println("메인 끝--");
	}

}
