package Programmers.daily.java_study;

class Solution16 {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=0;i<n;i++){
            answer+=1;
            while (answer%3 == 0 || (Integer.toString(answer)).contains("3")) answer ++;
        }
        return answer;
    }
}

public class 저주의숫자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
