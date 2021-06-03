package org.opentutorials.javatutorials.generic;

abstract class Info{ // interface로 사용해도 가능
	public abstract int getLevel1();
}

class EmployeeInfo2 extends Info{
	public int rank;
	EmployeeInfo2(int rank){ this.rank = rank; }
	public int getLevel1() {
		return this.rank;
	}
}

//class Person2<T, S>{
//	public T info;
//	public S id;
//	Person2(T info, S id){
//		this.info = info;
//		this.id = id;
//		}
//	public <U> void printInfo(U info) {
//		System.out.println(info);
//	}
//}

class Person2<T extends Info>{ // Info의 자식들만 T의 클래스로 올 수 있음
	public T info;
	Person2(T info){ this.info = info; }
}

public class GenericDemo2 {

	public static void main(String[] args) {
//		EmployeeInfo2 e = new EmployeeInfo2(1);
//		Integer i = new Integer(10);
//		Person2 p2 = new Person2(e, i);
//		p2.printInfo(e);
		Person2 p2 = new Person2(new EmployeeInfo2(1));
		Person2<String> p3 = new Person2<String>("부장");
	}

}
