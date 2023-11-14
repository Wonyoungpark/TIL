package baekjoon;


import java.util.Scanner;

public class No2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i=0;i<t;i++) {
            int n = sc.nextInt();
            String w = sc.next();
            String result = "";
            
            for(String c : w.split("")) result += c.repeat(n);
            System.out.println(result);
        }
    }
}