package ex0219.multichat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerChatGUIExam {
    //멤버 필드 //innerClass로 만들어서 소켓을 사용할 수 있도록 하기 위해서
    Socket sk;
    String userIp;
    List<ClientSocketThread> list = new ArrayList<ServerChatGUIExam.ClientSocketThread>(); //outputclass.innerclass

    public ServerChatGUIExam(){
        try(ServerSocket server = new ServerSocket(8001)){
            while(true){
                System.out.println("CLIENT 접속 대기 중");
                sk = server.accept(); //클라이언트 접속 대기
                userIp = sk.getInetAddress().toString();
                System.out.println(userIp+"님 접속 완료");

                //접속된 각 sk를 스레드로 생성 -> 자료구조에 추가(for 관리)
                ClientSocketThread th = new ClientSocketThread();
                list.add(th);
                th.start();

                System.out.println("[접속 인원 수] "+list.size()+"명");
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //List에 저장된 모든 ClientSocketThread를 꺼내서 모든 user에게 메시지 전송
    public void sendMessage(String msg){
        for(ClientSocketThread th:list) th.pw.println(msg); //ln이 붙어야 flush가 된다.
    }

    //클라이언트 Socket을 스레드로 생성, 클라이언트가 전송한 데이터를 읽어 모든 User에게 전송하는 스레드
    class ClientSocketThread extends Thread {
        BufferedReader br;
        PrintWriter pw;
        String nickName;

        @Override
        public void run(){
           try{
               //읽기
               br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
               //쓰기(전송)
               pw = new PrintWriter(sk.getOutputStream(), true); //autoFlush: 버퍼를 쓰면서 자동으로 비운다.

               //대화명 읽기
               nickName = br.readLine();

               //대화명을 모든 user에게 전송
               sendMessage(nickName+"님 입장");

               String inputData=null;
               while((inputData=br.readLine())!=null){
                   //읽은 내용을 모든 클라이언트에게 전송
                   sendMessage("["+nickName+"] "+inputData);
               }
           }catch (Exception e){
               //접속된 클라이언트 Socket이 닫힌 경우
               list.remove(this); //현재 스레드가 문제가 생겼기 때문에, 현재 스레드(ClientSocketThread)를 제거

               //남아 있는 모든 User에게 알린다.
               sendMessage("["+nickName+"] 퇴장");

               //서버 창에 출력
               System.out.println("["+nickName+"] 퇴장 | 현재 접속 인원: "+list.size());
           }
        }
    }

    public static void main(String[] args) {
        new ServerChatGUIExam();
    }
}
