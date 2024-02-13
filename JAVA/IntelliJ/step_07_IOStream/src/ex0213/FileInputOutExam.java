package ex0213;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutExam {
    public FileInputOutExam(){
        FileInputStream fis = null; //지역변수이기 때문에 초기값 선언
        FileOutputStream fos = null;
        try{
            //byte 단위로 파일 읽기
            fis = new FileInputStream("src/ex0213/test.txt");

            //1byte씩 읽기
//            while(true){
//                int i = fis.read();
//                if(i==-1) break;
//                System.out.println(i+" , "+(char)i);
//            }

            int length = fis.available(); //읽을 수 있는 byte 개수
            byte blist [] = new byte[length];
            fis.read(blist); //byte 배열의 크기만큼 한번에 읽어서 배열에 저장
//            for(byte b:blist) System.out.println(b);

            //byte 배열을 String으로 변환
            String str = new String(blist);
            System.out.println(str);

//            ////////////////////////////////
//            byte 단위로 저장(쓰기)
//            fos = new FileOutputStream("src/ex0213/writer.txt");
            fos = new FileOutputStream("src/ex0213/writer.txt",true); //파일 수정 가능
            fos.write(65);
            fos.write(66);
            fos.write(67);

            fos.write(68);
            fos.write(69);
            fos.write(13);
            fos.write(10);
            fos.write(70);

            //String을 byte배열로 변환
            String msg = "안녕하세요.Hello";
            fos.write(msg.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if(fis!=null) fis.close();
                if(fos!=null) fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        new FileInputOutExam();
    }
}
