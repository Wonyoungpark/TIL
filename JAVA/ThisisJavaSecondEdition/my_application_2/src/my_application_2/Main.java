package my_application_2;

import pack1.A;
//import pack2.B;
import pack3.C;


public class  Main {
	public static void main(String[] args) {
		A a = new A();
		a.method();
		
		//B은닉
//		B b = new B();
//		b.method();
		//my_module_a의 B를 A에 정의했기 때문에 B호출 가능
		
		C c2 = new C();
		c2.method();
	}
}

//project 형태로 참조 -> 여러 프로젝트로 나누어서 개발할 경우