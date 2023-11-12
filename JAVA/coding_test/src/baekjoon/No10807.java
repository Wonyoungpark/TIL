package baekjoon;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class No10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList();
        
        for(int i=0;i<num;i++) {
            arr.add(sc.nextInt());
        }
        int target = sc.nextInt();
        int cnt = Collections.frequency(arr,target);
        System.out.println(cnt);
    }
}