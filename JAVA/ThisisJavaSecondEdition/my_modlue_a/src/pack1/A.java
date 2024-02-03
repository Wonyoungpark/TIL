package pack1;

import pack2.B;
import pack3.C;

public class A {
	//Field
	//Constructor
	//Method
	public void method() {
		System.out.println("A-method 실행	");

		B b = new B();
		b.method();
	}

	public C getC(){
		C c = new C(); //modlue_a에서 module_b를 의존한다고 했기 때문에 C를 사용할 수 있다.
		return c;
	}
}
