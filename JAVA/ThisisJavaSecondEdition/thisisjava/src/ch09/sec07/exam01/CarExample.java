package ch09.sec07.exam01;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car();
		car.run1();
		
		car.run2();
		
		//매개값이 들어가는 자리
		car.run3(new Tire() {
			@Override
			public void roll() {
				System.out.println("익명 자식 Tire 객체3이 굴러갑니다.");
			}	
		}); //Tire를 상속한 자식클래스를 선언하고 그걸 매개변수로 전달(익명객체)
	}

}
