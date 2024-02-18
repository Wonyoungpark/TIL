package ch19.sec07;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

public class ChatServer {
	//필드
	ServerSocket serverSocket;
	ExecutorService threadPool = Executors.newFixedThreadPool(100);
	Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap<>()); //동기화되지 않은 맵을 받고, 동기화된 맵으로 리턴
	
	
	//메소드 : 서버 시작
	public void start() throws IOException {
		serverSocket = new ServerSocket(50001);
		System.out.println("[서버] 시작");
		
		Thread thread = new Thread(()->{ //Thread 클래스로부터 직접 생성 //생성자 매개값 : Runnable
			try {
				while(true) {
					Socket socket = serverSocket.accept();//클라이언트의 연결 요청 수락
					//수락한 통신객체를 바로 사용하지 않고, 소켓 클라이언트 내부에서 사용한다.
					// 소켓 클라이언트 생성 시, 서버에 대한 참조&통신객체에 대한 참조를 넘겨서 안쪽에서 두개의 객체에서 사용 가능하도록 해준다.
					SocketClient sc = new SocketClient(this,socket); //this:ChatServer //람다식 안의 this는 람다식 바깥 객체(Thread)를 실행하는 객체(ChatServer)이다.
				}
			}catch(Exception e) {}
		});
		thread.start();
	}
	
	//메소드: 클라이언트 연결 시 SocketClient 생성 및 추가
	public void addSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName+"@"+socketClient.clientIp;
		chatRoom.put(key, socketClient);
		System.out.println("입장: "+key);
		System.out.println("현재 채팅자 수: "+chatRoom.size()+"\n"); //chatRoom.size():엔트리 수
	}
	
	//메소드: 클라이언트 연결 종료 시 SocketClient 제거
	public void removeSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName+"@"+socketClient.clientIp;
		chatRoom.remove(key);
		System.out.println("퇴장: "+key);
		System.out.println("현재 채팅자 수: "+chatRoom.size()+"\n");
	}

	//메소드: 모든 클라이언트에게 메세지 전송
	public void sendToAll(SocketClient sender,String message) {
		JSONObject root = new JSONObject();
		root.put("clientIp", sender.clientIp);
		root.put("chatName", sender.chatName);
		root.put("message", message);
		String json = root.toString();
		
		Collection<SocketClient> socketClients = chatRoom.values();
		for(SocketClient sc:socketClients) {
			if(sc==sender) continue; //발신자에게는 메시지 보내지 않음
			sc.send(json);
		}
	}
	
	public void stop() {
		try {
			serverSocket.close();
			threadPool.shutdownNow();
			
//			Collection<SocketClient> socketClients = chatRoom.values();
//			for(SocketClient sc:socketClients) {
//				sc.close();
//			}
			
			chatRoom.values().stream().forEach(sc->sc.close());;
		}catch(IOException e) { }

		System.out.println("[서버] 종료");
	}
	
	public static void main(String[] args) {
		try {
			ChatServer chatServer = new ChatServer();
			chatServer.start();
			
			System.out.println("==========================================");
			System.out.println("서버 종료시 q 또는 Q 입력");
			System.out.println("==========================================");
			
			//입력
			Scanner sc = new Scanner(System.in);
			while(true) {
				String key = sc.nextLine();
				if(key.toLowerCase().equals("q")); break;
			}
			sc.close();
			
			chatServer.stop();
			
		} catch (IOException e) {
			System.out.println("[서버] "+e.getMessage());
		}
	}

}
