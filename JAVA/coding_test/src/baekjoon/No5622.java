package baekjoon;

import java.util.Scanner;

public class No5622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String abc = "abcdefghijklmnopqrstuvwxyz";
        int[] num = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
        String text = sc.next().toLowerCase();
        int time = 0;
        
        for (char c :text.toCharArray()) {
        	int idx = abc.indexOf(c);
        	time += 1+num[idx];
        }
        System.out.println(time);
    }
}