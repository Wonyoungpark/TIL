package ex0213;

import javax.swing.*;
import java.io.*;

public class BufferedFileCopyExam {
    public BufferedFileCopyExam(String readName, String writeName){
        FileInputStream fis=null;
        FileOutputStream fos = null;

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try{
            fis = new FileInputStream(readName);
            fos = new FileOutputStream(writeName);

            //Buffered 적용
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            int i=0;
            while((i=bis.read())!=-1) bos.write(i);
            System.out.println("복사 완료");
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(bis!=null) bis.close();
                if(bos!=null) bos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        String readName = JOptionPane.showInputDialog("읽을 파일명?");
        String writeName = JOptionPane.showInputDialog("작성할 파일명?");

        long start = System.nanoTime();
        new BufferedFileCopyExam(readName,writeName);
        long end = System.nanoTime();

        System.out.println("Buffered 사용 총"+(end-start));
    }
}
