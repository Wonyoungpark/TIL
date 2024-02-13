package ex0213;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KeyboardExam {
    public KeyboardExam() throws Exception {
//        //키보드 입력 받기
//        InputStream is = System.in; //byte 단위로 읽기
//        int i = is.read(); //1byte 읽기
//        System.out.println(i+" , "+(char)i);

        //InputStream->Reader로 변환해서 키보드 입력 처리
//        InputStreamReader isr = new InputStreamReader(System.in);
//        int i = isr.read();
//        System.out.println(i+" , "+(char)i);

//        //한줄 읽기가 가능한 Buffered를 사용
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String data = br.readLine();
//        System.out.println(data);


        //Scanner
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        System.out.println(data);
    }

    public static void main(String[] args) throws Exception {
        new KeyboardExam();
    }
}
