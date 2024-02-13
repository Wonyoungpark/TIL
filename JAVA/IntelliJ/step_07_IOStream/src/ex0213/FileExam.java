package ex0213;

import javax.swing.*;
import java.io.File;

public class FileExam {
    public FileExam() throws Exception {
        //파일 객체 생성
        String fileName = JOptionPane.showInputDialog("파일이름은?");
//        System.out.println("fileName: "+fileName);
        File file = new File(fileName);
        if(file.exists()) {
            System.out.println(fileName+" 존재");

            if(file.isDirectory()){
                System.out.println("폴더 내 파일/폴더 이름 갖고오기");
                String fnames [] = file.list();
                for(String name:fnames) System.out.println(name);
            } else{
                System.out.println("파일 정보****");
                System.out.println("file.canRead()="+file.canRead());
                System.out.println("file.canWrite()="+file.canWrite());
                System.out.println("file.getName()="+file.getName());
                System.out.println("file.getAbsolutePath()="+file.getAbsolutePath());
                System.out.println("file.length()="+file.length());

                System.out.println("삭제하겠습니다.");
                file.delete();
            }
        }
        else {
            System.out.println(fileName+"없으므로 생성");
            //파일 생성
            file.createNewFile();

            //폴더 생성
//            file.mkdir();
        }
    }

    public static void main(String[] args) throws Exception {
        new FileExam();
    }
}
