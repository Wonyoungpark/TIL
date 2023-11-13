package baekjoon;

import java.util.Scanner;

public class No9086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++) {
            String w = sc.next();
            System.out.println(w.charAt(0)+""+w.charAt(w.length()-1));
        }
    }
}