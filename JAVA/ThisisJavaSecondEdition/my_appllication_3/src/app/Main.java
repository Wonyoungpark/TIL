package app;

import pack1.A;
import pack2.B;
import pack3.C;


public class Main {
	public static void main(String[] args) {
		A a = new A();
		a.method();
		
		B b = new B();
		b.method();
		
		C c = new C();
		c.method();
	}
}

//jar 파일 형태로 참조 -> 오픈 소스 형태로 jar 파일을 다운 받을 경우 