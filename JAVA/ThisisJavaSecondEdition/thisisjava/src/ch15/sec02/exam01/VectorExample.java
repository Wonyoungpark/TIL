package ch15.sec02.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		List<Board> list = new Vector<>();
//		List<Board> list = new ArrayList<>();
		
		//작업 스레드 객체 생성
		Thread threadA = new Thread() {
			@Override
			public void run() {
				for(int i=0;i<=1000;i++) list.add(new Board("title"+i,"content"+i,"writter"+i));
			}
		};
		Thread threadB = new Thread() {
			@Override
			public void run() {
				for(int i=0;i<=1000;i++) list.add(new Board("title"+i,"content"+i,"writter"+i));
			}
		};
		
		
		//작업스레드 실행
		threadA.start();
		threadB.start();
		
		//작업 스레드들이 모두 종료될 때까지 메인 스레를 기다리게 함
		try {
			threadA.join();
			threadB.join();
		}catch(Exception e) {}
		
		//저장된 총 객체 수 얻기
		int size = list.size();
		System.out.println("총 객체 수"+size);
		System.out.println();
	}

}
