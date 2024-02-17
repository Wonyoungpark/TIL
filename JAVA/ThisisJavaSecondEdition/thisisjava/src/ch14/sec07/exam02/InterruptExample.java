package ch14.sec07.exam02;

public class InterruptExample {

	public static void main(String[] args) {
		Thread thread = new PrintThread();
		thread.start();
		
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {}
		
		thread.interrupt(); //일시정지 방해 //Thread.sleep(1);으로 잠깐의 대기 시간이 발생했을 때 방해
	}

}
