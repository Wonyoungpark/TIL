package ex0131.superEx;

class Animal{
	int a=10;
	int b = 5;;
	public void aa() {}
	public void bb() {}
}


class Cat extends Animal{ //Cat is Animal 성립(Polymorphism) //Cat is Object 성립 //Animal a=new Cat();
	int a=20;
	int c=7;
	
	@Override //재정의 @Annotation
	public void aa() {
		System.out.println("a="+a); //20
		System.out.println("this.a="+this.a); //20
		System.out.println("super.a="+super.a); //10
		
		System.out.println("b="+b); //5
		System.out.println("this.b="+this.b); //5
		System.out.println("super.b="+super.b); //5
		
		System.out.println("c="+c); //7
		System.out.println("this.c="+this.c); //7
//		System.out.println("super.c="+super.c);
	}
	
	public void cc() {
		System.out.println("Sub의 cc() call");
	}
	
	public void test() {
		aa(); //Sub
		this.aa(); //Sub
		super.aa(); //Super
		System.out.println("------");
		bb(); //Sub
		this.bb(); //Sub
		super.bb(); //Super
		System.out.println("------");
		cc(); //Sub
		this.cc(); //Sub
//		super.cc();
		System.out.println("------");
	}
}


public class SuperKeywordExam {

	public static void main(String[] args) {
		new Cat().aa();
		
		new Cat().test();
	}

}
