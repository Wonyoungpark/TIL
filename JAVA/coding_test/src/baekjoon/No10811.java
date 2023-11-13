package baekjoon;

import java.util.Scanner;

public class No10811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int basket = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[basket+1];
        
        for(int i=1;i<basket+1;i++) arr[i]=i;
        
        for(int i=0;i<n;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for(int j=a;j<b;j++){
            	int k = b--;
                int temp = arr[j];
                arr[j] = arr[k];
                arr[k] = temp;
            }
        }
        sc.close();
        
        for(int i=1;i<basket+1;i++) System.out.print(arr[i]+" ");
    }
}