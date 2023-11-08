package programmers;

import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        
        List<Character> b_arr = new ArrayList<>();
        for (char c : before.toCharArray()) b_arr.add(c);
        
        List<Character> a_arr = new ArrayList<>();
        for (char c : after.toCharArray()) a_arr.add(c);
        Collections.sort(b_arr);
        Collections.sort(a_arr);
        
        if (b_arr.equals(a_arr)) answer = 1;
        
        return answer;
    }
}

public class A로B만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
