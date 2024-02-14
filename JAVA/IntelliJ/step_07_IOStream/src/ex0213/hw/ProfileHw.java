package ex0213.hw;

import java.io.*;
import java.util.Scanner;

public class ProfileHw {

    public ProfileHw(String name) throws Exception {
        File file = new File("src/ex0213/hw/"+name+".txt");
        if(!file.exists()) throw new IOException(name+"에 해당하는 정보는 없습니다.");

        BufferedReader br = new BufferedReader(new FileReader(file));
        try(br){
            String data [] = br.readLine().split(":");
            System.out.println(name+"님 몸무게는 "+data[0]+"kg 이고 비번은 "+data[1]+" 입니다.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ProfileHw(String name, int weight, String pwd) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0213/hw/"+name+".txt"));
        try(bw){
            bw.write(String.valueOf(weight));
            bw.write(":");
            bw.write(pwd);
            bw.newLine();
            bw.close();
            System.out.println("저장 완료");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        Menu m = new Menu();
        m.printMenu();
    }
}
