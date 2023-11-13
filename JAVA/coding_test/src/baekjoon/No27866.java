package baekjoon;

import java.util.Scanner;

public class No27866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int n = sc.nextInt();
        System.out.println(word.charAt(n-1));
    }
}