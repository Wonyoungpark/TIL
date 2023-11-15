package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String w = br.readLine();
        
        StringBuffer sb = new StringBuffer(w);
        String rev = sb.reverse().toString();
        
        String[] arr = rev.split(" ");
        System.out.println(Math.max(Integer.parseInt(arr[0]),Integer.parseInt(arr[1])));
    }
}