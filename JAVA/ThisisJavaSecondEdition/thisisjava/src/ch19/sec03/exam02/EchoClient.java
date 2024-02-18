package ch19.sec03.exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",50001);
			System.out.println("[클라이언트] 연결 성공");
			//===================================================
//			//데이터 보내기
//			String sendMessage = "자바";
//			OutputStream os = socket.getOutputStream();
//			byte[] bytes = sendMessage.getBytes("utf-8");
//			os.write(bytes);
//			os.flush();
//			System.out.println("[클라이언트] 데이터 전송: "+sendMessage);
//			
//			//데이터 받기
//			InputStream is = socket.getInputStream();
//			bytes = new byte[1024];
//			int readByteCount = is.read(bytes);
//			String recieveMessage = new String(bytes,0,readByteCount,"utf-8"); //데이터 복원
//			System.out.println("[클라이언트] 데이터 받음: "+recieveMessage);
			//===================================================
			//데이터 보내기
			String sendMessage = "자바";
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(sendMessage);
			dos.flush();
			System.out.println("[클라이언트] 데이터 전송: "+sendMessage);
			
			//데이터 받기
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String recieveMessage = dis.readUTF();
			System.out.println("[클라이언트] 데이터 받음: "+recieveMessage);

			//===================================================
			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
		} catch (UnknownHostException e) {
			//ip/도메인 표기 방법이 잘못된 경우
			System.out.println("UnknownHostException"+e.toString());
		} catch (IOException e) {
			//ip/port번호가 존재하지 않는 경우
			System.out.println("IOException: "+ e.toString());
		}
	}

}
