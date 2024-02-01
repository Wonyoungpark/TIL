package ex0201.abstr;

abstract class Animal{
	int legs; //공통의 필드(속성)
	
	public void eat() {
		System.out.println("고기를 좋아한다.");
	}
	
	public abstract void sound();
	public abstract void run();
}


/*abstract*/ class Cat extends Animal{
	@Override
	public void eat() {
		System.out.println("고양이는 야채");
	}
	
	@Override
	public void sound() {
		System.out.println("야옹");
	}
	@Override
	public void run() {
		System.out.println("고양이 올라간다");
	}
}

class Pig extends Animal{

	@Override
	public void sound() {
		System.out.println("꿀꿀");
	}

	@Override
	public void run() {
		System.out.println("돼지 뛴다");
	}
	
}

class Dog extends Animal{

	@Override
	public void sound() {
		System.out.println("멍멍");
	}

	@Override
	public void run() {
		System.out.println("개 뛴다.");
	}
	
}


public class AbstractSample {

	public static void main(String[] args) {
		Animal an = null; //필드를 이용한 다형성
		an = new Cat();
		test(an);
		
		an = new Pig();
		test(an);
		
		an = new Dog();
		test(an);
	}
	
	public static void test(Animal an) { //매개변수를 이용한 다형성
		System.out.println("-----");
		//무조건 재정의된 메소드 호출
		an.eat();
		an.sound();
		an.run();
	}

}
