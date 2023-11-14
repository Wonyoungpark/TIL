package baekjoon;

import java.util.Scanner;

public class No1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String[] words = word.strip().split(" ");
        System.out.println(words.length);
    }
}