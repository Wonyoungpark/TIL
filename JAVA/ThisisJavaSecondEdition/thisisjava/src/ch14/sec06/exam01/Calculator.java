package ch14.sec06.exam01;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	//동기화 메소드 선언
	public synchronized void setMemory1(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		}catch(Exception e){}
		System.out.println(Thread.currentThread().getName()+":"+this.memory);
	}
	
	//동기화 블록 선언
	public synchronized void setMemory2(int memory) {
		synchronized (this) {
			this.memory = memory;
			try {
				Thread.sleep(2000);
			}catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+":"+this.memory);
		}
	}
	
}
