package org.opentutorials.javatutorials.exception;
import java.io.IOException;

class E {
	void throwArithmeticException() { // unchecked Exception -> RuntimeException이 부모
		throw new ArithmeticException();
	}
	void throwIOException() { // 반드시 예외처리 해야함(checked Exception이기 때문)
		try {
			throw new IOException();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	void throwIOException2() throws IOException{
		throw new IOException();
	}
}
