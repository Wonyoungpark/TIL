package ex0213;

import javax.swing.*;
import java.io.*;

public class AutoColsableBufferedFileCopyExam {
    public AutoColsableBufferedFileCopyExam(String readName, String writeName) throws Exception {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(readName));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(writeName));

        try(bis;bos) { //AutoClosable 구현 필요 & 자동으로 close 호출 =>flush/close() 따로 사용할 필요가 없음

            int i=0;
            while((i=bis.read())!=-1) bos.write(i);
            System.out.println("복사 완료");
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        String readName = JOptionPane.showInputDialog("읽을 파일명?");
        String writeName = JOptionPane.showInputDialog("작성할 파일명?");

        long start = System.nanoTime();
        new AutoColsableBufferedFileCopyExam(readName,writeName);
        long end = System.nanoTime();

        System.out.println("Buffered 사용 총"+(end-start));
    }
}
