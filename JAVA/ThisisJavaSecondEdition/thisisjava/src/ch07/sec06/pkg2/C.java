package ch07.sec06.pkg2;

import ch07.sec06.pkg1.A;

public class C {
	public void method() {
		// protected인 A를 다른 패키지에서 호출 불가
//		A a = new A();
//		a.field = "value";
//		a.method();
	}
}
