package ex0213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ReaderWriterExam {
    public ReaderWriterExam(){
        //문자단위로 파일 읽기 (Buffered 이용)
        try(BufferedReader br = new BufferedReader(new FileReader("src/ex0213/test.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0213/info.txt"))){

//            //한문자씩 읽기
//            while (true){
//                int i = br.read();
//                if(i==-1) break;
//                System.out.println(i+", "+(char)i);
//            }

            //한줄씩 읽기
            String data =null;
            while((data = br.readLine())!=null) {
                System.out.println(data);
                bw.write(data);
            }


            //작성
            bw.write(65);
            bw.write("BCDEF");
            bw.write(32);
            bw.write("재미있다");
            bw.newLine();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new ReaderWriterExam();
    }
}
