package ch06.sec07.exam05;

public class CarExample {

	public static void main(String[] args) {
		Car car1 = new Car("자가용");
		System.out.println("car1.company:"+car1.company);
		System.out.println("car1.model:"+car1.model);
		System.out.println("car1.color"+car1.color);
		
		Car car2 = new Car("자가용","빨강");

		System.out.println("car1.company:"+car2.company);
		System.out.println("car1.model:"+car2.model);
		System.out.println("car1.color"+car2.color);
	}

}
