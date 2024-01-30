package ex0130.constructor;

class Test{
	private static Test t = new Test();
	//private생성자: for 외부에서 객체를 직접 생성할 수 없도록
	private Test(){} //기본으로 존재
	
	//자기 자신 객체를 직접 생성해서 리턴하는 메소드 제공
	// main()에서 호출하려면 static이 필요함
	// static이 없다면, 같은 클래스 아니고, static도 아니고, 객체 생성도 못하기 때문.
	public static Test getInstance() { //Test타입으로 리턴, getInstance명은 관례
		return t;
	}
}

public class PrivateConstructorExam {

	public static void main(String[] args) {
//		new Test(); //생성자 호출 //Test가 private이기에 호출 불가
		Test t1 = Test.getInstance();
		Test t2 = Test.getInstance();
	}

}
