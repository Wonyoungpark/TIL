package ex0205;

class Test {
	public void aa(int i) throws ArithmeticException {
		System.out.println("Test aa() 호출");
		
		try {
			this.bb(i);
		} finally {
			System.out.println("Test aa() 끝");
		}
	}
	
	public void bb(int i) throws ArithmeticException {
		try {
			System.out.println("Test bb() 호출");
			
			int result = 100/i;
			System.out.println("나눈 결과 = "+result);
		} finally{
			System.out.println("Test bb() 끝");
		}
	}
}

public class ThrowsExceptionExam {

	public static void main(String[] args) {
		System.out.println("메인 시작");
		try {
			new Test().aa(0);
		} catch(ArithmeticException e) {
			System.out.println("main()의 catch");
		}
		System.out.println("메인 끝");

	}

}
