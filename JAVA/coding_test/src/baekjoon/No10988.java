package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10988 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String str = br.readLine();
        StringBuffer sb = new StringBuffer(str);
        if (str.equals(sb.reverse().toString())) System.out.println(1);
        else System.out.println(0);
    }
}