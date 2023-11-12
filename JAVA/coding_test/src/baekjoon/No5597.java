package baekjoon;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class No5597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> stu = new ArrayList();
        for(int i=0;i<28;i++) {
            stu.add(sc.nextInt());
        }
        
        Collections.sort(stu);
        
        for(int i=1;i<31;i++) {
            if(!stu.contains(i)) System.out.println(i);
        }
    }
}