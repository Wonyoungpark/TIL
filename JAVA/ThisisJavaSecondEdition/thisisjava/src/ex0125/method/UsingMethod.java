package ex0125.method;

//UsingMethod.java
class UsingMethodExam{
     //아래와 같은 메소드를 작성하세요.
   
     /*Method이름 :  methodExam03_01
     자기자신만 접근가능
     ReturnType : 정수
     Parameter : 정수 1개
	(구현부에서)하는 일 : 
	methodExam03_01이 호출되었습니다. 출력
	인수로 받은 정수 출력 
	정수*2 리턴. */
		
	private int methodExam03_01(int a) {
		System.out.println("methodExam03_01이 호출되었습니다. ");
		System.out.println(a);
		return a*2;
	}
	 
	 /*Method이름 :  methodExam03_02
     어디서나 아무나 접근가능
     Return String
     Parameter : String 1개, 정수 1개
	(구현부에서)하는 일 : 
		methodExam03_02가 호출되었습니다. 출력
		인수로 받은 String 에 바보를 붙여서 출력
		두번째인수로 들어온 값을 methodExam03_01로 넣어 주며 methodExam03_01을 호출하고 리턴하는 값을 출력
		인수로 받은 String 에 바보를 붙여서 리턴
	*/	
	
	public String methodExam03_02(String a, int b) {
		System.out.println("methodExam03_02가 호출되었습니다. ");
		System.out.println(a+"바보");
		int m1 = this.methodExam03_01(b); //private이기에 내부에서 가능
		System.out.println(m1);
		return a+"바보";
	}
	
	 /*Method이름 :  methodExam03_03
     같은 package에서 아무나 접근 가능
     ReturnType : 리턴안함
     Parameter : 정수 1개와 String 1개
     (구현부에서)하는 일 : 
		methodExam03_03이 호출되었습니다. 출력
		인수로 받은 정수 1개와 String 1개를 넘겨주며
		methodExam03_02호출
	*/	
		
	void methodExam03_03(int a, String b) {
		System.out.println("methodExam03_03이 호출되었습니다. ");
		this.methodExam03_02(b, a);
	}
     
     /*Method이름 :  methodExam03_04
     상속관계라면 어디서나 접근 가능
     ReturnType : 실수(부동소수형)
     Parameter : 첫번째 인수(정수),두번째 인수(실수), 세번째인수(정수)
	(구현부에서)하는 일 : 
		methodExam03_04가 호출되었습니다. 출력
		인수로 들어온 값을 이용해 
		MakeMethodExam02객체의 methodExam02_04메소드 호출하고
		method02_04가 리턴하는 값을 리턴
	*/	
	
	protected double methodExam03_04(int a, double b, int c) {
		System.out.println("methodExam03_04가 호출되었습니다. ");
		MakeMethodExam02 mm2 = new MakeMethodExam02();
		double res = mm2.methodExam02_04(a,b,c);
		return res;
	}
		
} // UsingMethodExam 끝

class UsingMethod{
	//메인메소드에서
	//UsingMethodExam의 호출가능한 메소드들을 호출하고
	// 리턴하는 값 있다면 출력
	public static void main(String[] args) {
		UsingMethodExam um = new UsingMethodExam();
//		this.methodExam03_01(1); //private이기에 접근 불
		um.methodExam03_02("1",2);
	}
}

  
