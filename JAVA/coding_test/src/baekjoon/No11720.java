package baekjoon;

import java.util.Scanner;

public class No11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String w = sc.next();
        sc.close();
        
        int sum = 0;
        for (int i=0;i<n;i++) {
            sum += w.charAt(i)-'0';
        }
        System.out.println(sum);
    }
}