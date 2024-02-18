package ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class SocketClient {
	//필드
	ChatServer chatServer;
	Socket socket;
	String clientIp;
	String chatName;
	DataInputStream dis;
	DataOutputStream dos;
	
	//생성자
	public SocketClient(ChatServer chatServer, Socket socket) {
		try {
			this.chatServer = chatServer;
			this.socket = socket;
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
			InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress(); //getHostName()을 사용하기 위해 캐스팅
			this.clientIp = isa.getHostName();
			
			receive();
		} catch (IOException e) {
			
		}
	}
	
	public void receive() { //클라이언트가 전송한 데이터를 받기 위해
		chatServer.threadPool.execute(()->{
			try {
				while(true) {
					String receiveJson = dis.readUTF(); //네트워크 연결이 끊간다면 예외 발생
					
					JSONObject jsonObject = new JSONObject(receiveJson); //중괄호로 묶여있어서 jsonObject //대괄호라면 jsonArray
					String command = jsonObject.getString("command"); //{"command":"xxx", ...}
					
					switch(command) {
					case "incomming":
						this.chatName = jsonObject.getString("data");
						chatServer.sendToAll(this, "참가"); //this : SocketClient
						chatServer.addSocketClient(this);
						break;
					case "message":
						String message = jsonObject.getString("data");
						chatServer.sendToAll(this, message);
						break;
					}
				}
			} catch(IOException e) {
				chatServer.sendToAll(this, "퇴장");
				chatServer.removeSocketClient(this);
			}
		});
	}

	public void send(String json) { //클라이언트로 데이터를 전송하기 위한 메소드
		try {
			dos.writeUTF(json);
			dos.flush(); //close()는 하면 안됨-> 재사용해야됨
		} catch (IOException e) {
		}
	}
	
	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
		}
	}
}
