package programmers;

import java.util.Arrays;

class Solution18 {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        int min = sides[0];
        int max = sides[1];
        
        for (int i=max-min+1;i<=max;i++) answer++;
        for (int i=max+1;i<max+min;i++) answer++;
        
        return answer;
    }
}

public class 삼각형의완성조건2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
