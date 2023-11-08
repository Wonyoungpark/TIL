package programmers;

class Solution17 {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        int len = spell.length;
        
        for (String d:dic) {
            int ds = 0;
            for (String s:spell){
                if (d.contains(s)) ds++;
            }
            if (ds==len) answer++;
        }
        if (answer==0) answer = 2;
        return answer;
    }
}

public class 외계어사전 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
