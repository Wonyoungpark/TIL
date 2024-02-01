package ex0201.abstr;
//Error 를 수정하고 이유를 주석으로 처리하세요.

final class FinalClassExam{ //상속 불가, 생성 가능
 final int i = -999999; //고정값, 초기화 필수, 값변경 불가
}


abstract class AbstractClassExam{ //상속 가능, 생성 불가
    abstract String abstractMethodExam(int i,String s); //기능 없고 재정의를 위한 메소드
    final int finalMethodExam(int i, int j){ //재정의 불가
        return i+j;
    }
}


class Sample01 extends AbstractClassExam{
	String abstractMethodExam(int i,String s){
		System.out.println("return "+s+i);
		return s+i;
	}
	
//	final이 선언된 메소드이므로 재정의 불가
//	int finalMethodExam(int i, int j){
//		return i*j;
//	}
}


//final이 붙은 클래스이기에 상속 불가
//class Sample02 extends FinalClassExam{  }

 
 abstract class Sample03 extends AbstractClassExam{ //추상 클래스를 상속받았기 때문에 abstract를 붙어야 된다. 43줄에 abstract클래스 있음.

//	 String abstractMethodExam(int i,String s) {	  //오버로딩이기 때문에 인수를 바꿔야한다.
//		 return s+i;
//	 }
	 String abstractMethodExam(String s,int i) {
		 return s+i;
	 }
	 
	abstract String abstractMethodExam(int i,String s); 
	
	
	
	void sampleMethod03(){
		System.out.println("void sampleMethod03() 호출 됨");
	}
}

class AbstractFinalClassTest{
    public static void main(String args[]){
		AbstractClassExam ace;// = new AbstractClassExam();//abstract메소드는 new를 사용할 수 없다.
		FinalClassExam fce = new FinalClassExam();
//		fce.i=100000; //final은 값 변경 불가
		Sample01 s01 = new Sample01();
		AbstractClassExam aceS01 = new Sample01();
		aceS01.abstractMethodExam(700,"_999");
	}
}