package ex0216.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {
    public ServerExam(){
        try(ServerSocket server = new ServerSocket(8000)){
            while(true){
                System.out.println("클라이언트 접속 대기중");
                Socket sk = server.accept();//클라이언트 대기 감지
                System.out.println(sk.getInetAddress()+" 접속"); //접속된 클라이언트의 ip 갖고 오기

                //클라이언트가 보내온 데이터 읽기
                InputStream is = sk.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String data = br.readLine();
                System.out.println("클라이언트가 보내온 내용 : "+data);

                //서버에게 응답(데이터 전송)
                PrintWriter pw = new PrintWriter(sk.getOutputStream(),true);
                pw.println("서버에 접속");
                sk.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ServerExam();
    }
}
