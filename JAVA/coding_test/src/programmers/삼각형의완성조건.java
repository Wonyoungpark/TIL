package programmers;

import java.util.*;

class Solution6 {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        
        if (sides[2] < sides[0]+sides[1]) answer = 1;
        else answer = 2;
        
        return answer;
    }
}

public class 삼각형의완성조건 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
