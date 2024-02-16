package ex0216.chat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//키보드 입력 받아서 상대에게 데이터 전송
public class SendThread extends Thread {
    Socket sk;

    public SendThread(Socket sk, String name) {
        super(name); //스레드의 이름 설정
        this.sk = sk;
    }

    @Override
    public void run(){

        //키보드 입력 받기
        Scanner sc = new Scanner(System.in);
        try(PrintWriter pw = new PrintWriter(sk.getOutputStream(),true);){
            while(true){
                String input = sc.nextLine();
                if(input.equals("exit")) {
                    pw.println(input);
                    break;
                }
                else pw.println(super.getName()+" 가 보낸 내용: "+input);

                //상대에게 전송
                pw.println(super.getName());
            }
            System.out.println(super.getName()+"의 send 스레드 종료합니다.");
        }catch (Exception e){
//            e.printStackTrace();
            System.out.println(super.getName()+"의 send 스레드 catch영역");
        }

    }
}
