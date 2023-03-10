package Programmers.daily.java_study;

class Solution23 {
    public int solution(String my_string) {
        int answer = 0;
        
        for(char my:my_string.toCharArray()){
            if (Character.isDigit(my)) answer += Character.getNumericValue(my);
        }
        return answer;
    }
}

public class 숨어있는숫자의덧셈1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
