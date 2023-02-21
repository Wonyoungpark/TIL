package Programmers.daily.java_study;

import java.util.*;

class Solution13 {
    public int solution(int a, int b) {
        int answer = 2;
        
        int gcd = GCD(a,b);
        if (gcd != 1) {
            b /= gcd;
            a /= gcd;
        }
        
        if (b == 1) return 1;
        int i = 2;
        Set<Integer> arr = new HashSet<>();
        while (i<=b) {
            if (b == 1) return 1;
            if (b%i == 0) {
                arr.add(i);
                b /= i;
            }
            else i++;
        }
        if (arr.isEmpty()==false){
            arr.remove(2);
            arr.remove(5);
            if (arr.isEmpty()) answer = 1;
        }
        
        return answer;
    }
    
    
    public static int GCD(int p, int q){
        if (q==0) return p;
        return GCD(q,p%q);
    }
}

public class 유한소수판별하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


// 참고 사이트 : https://velog.io/@knh4437/백준-1735번-분수-합
