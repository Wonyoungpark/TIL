package ch14.sec02;

public class MainThreadExample {

	public static void main(String[] args) {
		System.out.println("시작");
		
		Thread currentThread = Thread.currentThread(); //현재 스레드의 객체의 요구를 리턴
		System.out.println(currentThread.getName());
		
		System.out.println("종료");
	}

}
