package ex0216.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChatExam {
    Socket sk; //member field ->InnerClass에서 사용하기 위해

    public ServerChatExam(){
        try(ServerSocket server = new ServerSocket(9000)){
            System.out.println("클라이언트 접속 대기 중");
            sk = server.accept();//클라이언트 접속 대기

            //읽기 : Inner class : 상대가 보낸 데이터 읽기
            new ServerReciveThread().start();

            //쓰기 : Outer Class : 입력 받은 걸 상대에게 전송
            new SendThread(sk,"SERVER").start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ServerChatExam();
    }

    //inner class : Outer class의 필드와 메소드를 접근 가능
    //Outer$inner.class
    class ServerReciveThread extends Thread{
        @Override
        public void run(){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()))){
                while (true){
                    String rdata = br.readLine();
                    if(rdata.equals("exit")) break;
                    System.out.println(rdata);
                }
                System.out.println("서버 recieve 스레드 종료");
            }catch (Exception e){
//                e.printStackTrace();
                System.out.println("ServerReciveThread의 catch영역");
            } finally {
                System.out.println("서버 프로그램 종료하겠습니다");
                System.exit(0);
            }
        }
    }
}
