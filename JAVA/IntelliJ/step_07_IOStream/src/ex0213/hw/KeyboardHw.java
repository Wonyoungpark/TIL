package ex0213.hw;

import java.io.*;
import java.util.Scanner;

public class KeyboardHw {
    public KeyboardHw() throws Exception {
        String data;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0213/hw/save.txt"));

        try(br;bw){
            while(true){
                System.out.print("입력> ");
                data = br.readLine();
                if(data.equals("exit")) break;
                System.out.println(data);
                bw.write(data);
                bw.newLine();
                bw.flush();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new KeyboardHw();
    }
}
