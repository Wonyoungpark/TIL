package baekjoon;

import java.util.Scanner;

public class No3003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int[] chess = {1,1,2,2,2,8};
        
        for (int i=0;i<6;i++) {
        	int n = chess[i] - Integer.parseInt(str[i]);
        	System.out.print(n+" ");
        }
    }
}