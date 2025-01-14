package ch14.sec03.exam03;

import java.awt.Toolkit;

public class BeepPrintExample {

	public static void main(String[] args) {
		// 작업1
		Thread thread = new Thread() {
			@Override
			public void run(){
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i=0;i<5;i++) {
					toolkit.beep();
					try {
						Thread.sleep(500);
					}catch(InterruptedException e) {}
				}
			}
		};
		thread.start(); //새로운 스레드 실행
		
		
		// 작업2
		for(int i=0;i<5;i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {}
		}
	}

}
