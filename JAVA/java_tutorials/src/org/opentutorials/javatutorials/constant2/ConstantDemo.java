package org.opentutorials.javatutorials.constant2;

/*class Fruit{
	public static final Fruit APPLE = new Fruit();
	public static final Fruit PEACH = new Fruit();
	public static final Fruit BANANA = new Fruit();
}*/
enum Fruit{
	APPLE("red"), PEACH("pink"), BANANA("yellow");
	private String color;
	
	public String getColor() {
		return this.color;
	}
	Fruit(String color){
		System.out.println("Call Constructor "+this); // 상수하나 생성할때마다 Fruit()생성자 호출
		this.color = color;
	}
}

/*
 * class Company{ public static final Company GOOGLE = new Company(); public
 * static final Company APPLE = new Company(); public static final Company
 * ORACLE = new Company(); }
 */
enum Company{
	GOOGLE, APPLE, ORACLE;
}

public class ConstantDemo {
//	private final static int FRUIT_APPLE = 1;
//	private final static int FRUIT_PEACH = 2;
//	private final static int FRUIT_BANANA = 3;
//	
//	private final static int COMPANY_GOOGLE = 1;
//	private final static int COMPANY_APPLE = 2;
//	private final static int COMPANY_ORACLE = 3;
	
	public static void main(String[] args) {
		
		Fruit type = Fruit.APPLE; // 한번 Fruit 정의했으니 아래에서 다시 정의할 필요 없음
		
		switch(type) {
		case APPLE:
			System.out.println(57+" kcal, color "+Fruit.APPLE.getColor());
			break;
		case PEACH:
			System.out.println(34+" kcal, color "+Fruit.PEACH.getColor());
			break;
		case BANANA:
			System.out.println(93+" kcal, color "+Fruit.BANANA.getColor());
			break;
		}
		

		for(Fruit f: Fruit.values()) { // enum을 사용하면 상수를 배열처럼 하나씩 꺼내서 처리 가능
			System.out.println(f+" "+f.getColor());
		}
	}

}
