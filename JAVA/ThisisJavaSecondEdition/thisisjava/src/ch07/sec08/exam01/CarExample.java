package ch07.sec08.exam01;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.tire = new Tire();
		myCar.run(); //Tire.java 호출
		
		myCar.tire = new HankookTire();
		myCar.run(); //HankookTire.java 호출
		
		myCar.tire = new KumhoTire();
		myCar.run(); //KumhoTire.java 호출
	}

}
