package baekjoon;

import java.util.Scanner;

public class No10810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int basket = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[basket];
        
        for(int i=0;i<n;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            for(int j=a-1;j<b;j++){
                arr[j] = c;
            }
        }
        
        for(int i=0;i<basket;i++) System.out.print(arr[i] +" ");
    }
}