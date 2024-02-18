package ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONObject;

public class ChatClient {
	//필드
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String chatName;
	
	//메소드 :서버연결
	public void connect() throws IOException {
		socket = new Socket("localhost",50001);
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
		System.out.println("[클라이언트] 서버에 연결");
	}
	
	//메소드 :JSON 받기
	public void receive() {
		Thread thread = new Thread(()->{ //새로운 스레드 생성
			try {
				while(true) {
					String json = dis.readUTF();
					JSONObject root = new JSONObject(json); //json 파싱
					String clientIp = root.getString("clientIp");
					String chatName = root.getString("chatName");
					String message = root.getString("message");
					System.out.println("<"+chatName+"@"+clientIp+"> "+message);
				}
			}catch(Exception e) { //서버가 연결이 끊기면 채팅을 진행할 이유가 없음
				System.out.println("[클라이언트] 서버 연결 끊김");
				System.exit(0);
			}
		});
		thread.start();
	}
	
	//메소드 :JSON 전송
	public void send(String json) throws IOException {
		dos.writeUTF(json);
		dos.flush(); //write 후에는 항상 flush
	}
	
	//메소드 :서버와 연결 끊기
	public void unconnect() throws IOException{
		socket.close();
	}
	
	public static void main(String[] args) {
		try {
			ChatClient chatClient = new ChatClient(); //객체 생성
			chatClient.connect(); //서버와 연결
			
			Scanner sc = new Scanner(System.in);
			System.out.print("대화명 입력: ");
			chatClient.chatName = sc.nextLine();
			
			JSONObject jsonObject = new JSONObject(); //전송할 데이터를 json으로 변환
			jsonObject.put("command", "incomming"); //채팅방에 가입 시켜달라
			jsonObject.put("data", chatClient.chatName);
			String json = jsonObject.toString();
			chatClient.send(json); //json 전송
			
			chatClient.receive(); //서버에서 올 응답을 받을 준비

			System.out.println("==========================================");
			System.out.println("보낼 메시지를 입력하고 Enter");
			System.out.println("서버 종료시 q 또는 Q 입력");
			System.out.println("==========================================");
			
			while(true) {
				String message = sc.nextLine();
				if(message.toLowerCase().equals("q")) break;
				else {
					jsonObject = new JSONObject();
					jsonObject.put("command", "message");
					jsonObject.put("data", message);
					json = jsonObject.toString();
					chatClient.send(json);
				}
			}
			
			sc.close();
			chatClient.unconnect();
		}catch(Exception e) {
			System.out.println("[클라이언트] 서버 연결 불가");
		}
		System.out.println("[클라이언트] 종료");
	}
}
