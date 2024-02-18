package ch19.sec04;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class NewsServer {
	private static DatagramSocket datagramSocket;

	public static void main(String[] args) {
		System.out.println("==========================================");
		System.out.println("서버 종료시 q 또는 Q 입력");
		System.out.println("==========================================");

		//TCP 서버 시작
		startServer();
		
		//입력
		Scanner sc = new Scanner(System.in);
		while(true) {
			String key = sc.nextLine();
			if(key.toLowerCase().equals("q")); break;
		}
		sc.close();
		
		//TCP 서버 종료
		stopServer();
	}

	public static void startServer() {
		//작업 스레드 정의
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					//DatagramSocket 생성 및 Port 바인딩
					datagramSocket = new DatagramSocket(50001);
					System.out.println("[서버] 시작");
					
					while(true) {//서버는 클라이언트 요청을 계속 받아야하므로 반복문이 필요
						//클라이언트가 구독하고 싶은 뉴스 주제 얻기
						DatagramPacket recievePacket = new DatagramPacket(new byte[1024],1024);
						System.out.println("클라이언트의 희망 뉴스 종료 얻기 대기");
						datagramSocket.receive(recievePacket);
						String newsKind = new String(recievePacket.getData(),0,recievePacket.getLength(),"utf-8"); //byte배열의 참조 얻을 수 있음
						
						//클라이언트의 ip&port 정보가 있는 SocketAddress 얻기
						SocketAddress socketAddress = recievePacket.getSocketAddress();
						
						//10개의 뉴스를 클라이언트로 전송
						for(int i=0;i<=10;i++) {
							String data = newsKind+": 뉴스"+i;
							byte[] bytes = data.getBytes("utf-8");
							DatagramPacket sendPacket = new DatagramPacket(bytes,0,bytes.length, socketAddress);
							datagramSocket.send(sendPacket);
							Thread.sleep(1000);
						}
					}
				} catch (Exception e) {
					System.out.println("[서버] "+e.getMessage());
				}
			}
		};
		//작업 스레드 시작
		thread.start();
	}
	
	public static void stopServer() {
		datagramSocket.close();
		System.out.println("[서버] 종료");
	}
}
