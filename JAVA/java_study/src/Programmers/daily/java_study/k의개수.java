package Programmers.daily.java_study;

class Solution7 {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String q = Integer.toString(k);
        
        for(int n=i;n<=j;n++){
            String s = Integer.toString(n);
            int cnt = s.length()-s.replace(q,"").length();
            answer += cnt;
        }
        return answer;
    }
}

public class k의개수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
