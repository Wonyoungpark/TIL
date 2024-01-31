package ex0131.superEx;

class Parent {
	Parent() {System.out.println(1);}
	Parent(int i) {System.out.println(2);}
	Parent(String s) {System.out.println(33);}
}

class Child extends Parent { //Child is a Parent 성립
	Child(){ System.out.println(4);}
	Child(int i){ System.out.println(5);}
	Child(boolean b){ System.out.println(6);}
}


public class SuperConstructorExam {

	public static void main(String[] args) {
		
		//1이 출력 => 자식생성자 구현부 첫줄에 super()가 생략됐다.
		// 부모의 기본 생성자를 호출한다.
		new Child();
		new Child(5);
		new Child(true);
		
		//만약, 부모의 생성자가 하나도 없다면, 기본생성자자는 자동 삽입되어진다.
		new Child();
		new Child(5);
		new Child(true);
		
		//만약, 부모의 기본생성자는 없고 인수 있는 생성자만 있다면, 부모의 기본생성자가 없기 때문
	}

}
