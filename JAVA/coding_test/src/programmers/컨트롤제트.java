package programmers;

import java.util.List;

class Solution30 {
    public int solution(String s) {
        int answer = 0;
        String[] arr = s.split(" ");
        int prev = 0;
        
        for (String a:arr){
            if (a.equals("Z")) answer -= prev;
            else {
                int n = Integer.parseInt(a);
                answer += n;
                prev = n;
            }
        }
        return answer;
    }
}

public class 컨트롤제트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
