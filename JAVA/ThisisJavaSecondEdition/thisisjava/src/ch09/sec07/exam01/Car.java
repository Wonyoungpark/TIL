package ch09.sec07.exam01;

public class Car {
	private Tire tire1 = new Tire();
	private Tire tire2 = new Tire();
	
	public void run1() {
		tire1.roll();
		tire2.roll();
	}
}
