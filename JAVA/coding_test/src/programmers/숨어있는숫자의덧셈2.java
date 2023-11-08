package programmers;

import java.util.LinkedList;
import java.util.Queue;

class Solution21 {
    public int solution(String my_string) {
        int answer = 0;
        String str = "";
        Boolean flag = true;
        
        for(char my : my_string.toCharArray()) {
            if (Character.isDigit(my)) {
                str+= my;
                flag = false;
            }
            else if (str!="") {
                answer += Integer.valueOf(str);
                str = "";
            }
        }
        if (str!="") {
                answer += Integer.valueOf(str);
                flag = false;
        }
        if (flag==true) return 0;
        return answer;
    }
}

public class 숨어있는숫자의덧셈2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
