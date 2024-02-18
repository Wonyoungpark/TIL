package ch19.sec03.exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
	private static ServerSocket serverSocket; //main()에서 객체 선언 없이 바로 사용하기 위해 static 선언

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
				//ServerSocket 생성 및 Port 바인딩
				try {
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버] 시작");
					
					while(true) { //여러 클라이언트의 연결 요청을 수락하기 위해 while문 필요
						System.out.println("\n[서버] 연결 요청을 기다림\n");
						//연결 수락
						Socket socket = serverSocket.accept();
						//연결된 client 정보 얻기
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						String clientIp = isa.getHostString();
						System.out.println("[서버] "+clientIp+"의 연결요청을 수락");
						//===================================================
//						//데이터 받기
//						InputStream is = socket.getInputStream();
//						byte[] bytes = new byte[1024];
//						int readByteCount = is.read(bytes);
//						String message = new String(bytes,0,readByteCount,"utf-8");//byte를 string으로 복원
//						
//						//데이터 보내기
//						OutputStream os = socket.getOutputStream();
//						bytes = message.getBytes("utf-8");
//						os.write(bytes);
//						os.flush();
//						System.out.println("[서버] 받은 데이터를 재전송: "+message);
						//===================================================
						//데이터 받기
						DataInputStream dis = new DataInputStream(socket.getInputStream());
						String message = dis.readUTF();
						
						//데이터 보내기
						DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
						dos.writeUTF(message);
						dos.flush();
						System.out.println("[서버] 받은 데이터를 재전송: "+message);

						//===================================================
						//연결 끊기
						socket.close();
						System.out.println("[서버] "+clientIp+"의 연결을 끊음");
					}
				} catch (IOException e) {
					System.out.println("[서버]"+e.toString());
				}
			}
		};
		//스레드 시작
		thread.start();
	}
	
	public static void stopServer() {
		//ServerSocket을 닫고 Port 언바인딩
		try {
			serverSocket.close();
		} catch (IOException e) {
		}
	}
}
