package ex0213;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyExam {
    public FileCopyExam(String readName,String writeName){
        FileInputStream fis=null;
        FileOutputStream fos = null;

        try{
            fis = new FileInputStream(readName);
            fos = new FileOutputStream(writeName);

            int i=0;
            while((i=fis.read())!=-1) fos.write(i);
            System.out.println("복사 완료");
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(fis!=null) fis.close();
                if(fos!=null) fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        String readName = JOptionPane.showInputDialog("읽을 파일명?");
        String writeName = JOptionPane.showInputDialog("작성할 파일명?");

        long start = System.nanoTime();
        new FileCopyExam(readName,writeName);
        long end = System.nanoTime();

        System.out.println("Buffered 없이 "+start+" , "+end);
    }
}
