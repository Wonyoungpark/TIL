package Programmers.daily.java_study;

class Solution9 {
    public int solution(int chicken) {
        int answer = 0;
        int cnt = 0;
        
        while(chicken>=10){
            int serve = chicken/10;
            answer += serve;
            chicken = chicken - serve*10+ serve;
        }
        return answer;
    }
}

public class 치킨쿠폰 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
