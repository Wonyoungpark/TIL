package ex0216.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientChatExam {
    public ClientChatExam(){
        try{
            Socket sk = new Socket("127.0.0.1",9000);
            System.out.println("서버와의 채팅 시작");

            //보내는 스레드
            new SendThread(sk,"CLIENT").start();

            //받는 스레드
            new Thread(()->{
                try(BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()))){
                    while (true){
                        String rdata = br.readLine();
                        if(rdata.equals("exit")) break;
                        System.out.println(rdata);
                    }
                    System.out.println("클라이언트 recieve 스레드 종료");
                }catch (Exception e){
//                    e.printStackTrace();
                    System.out.println("ClientChatExam의 catch영역");
                } finally {
                    System.out.println("클라이언트 프로그램을 종료합니다");
                    System.exit(0);
                }
            }).start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ClientChatExam();
    }
}
