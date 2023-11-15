package baekjoon;

import java.util.Scanner;

public class No1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().strip();
        if(word=="") System.out.println(0);
        else {
            String[] words = word.split(" ");
            System.out.println(words.length);
        }
    }
}