package baekjoon;

import java.util.Scanner;

public class No2525 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long h = sc.nextLong();
        long m = sc.nextLong();
        long a = sc.nextLong();

        h += a/60;
        m += a%60;
        
        if(m>=60){
            h += 1;
            m -= 60;
        }
        if(h>=24) {
            h -= 24;
        }
        System.out.println(h + " " + m);
    }
}