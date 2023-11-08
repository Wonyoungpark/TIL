package programmers;

class Solution8 {
    public String solution(String bin1, String bin2) {
        String answer = "";
        int s1 = Integer.parseInt(bin1,2);
        int s2 = Integer.parseInt(bin2,2);
        
        answer = Integer.toBinaryString(s1+s2);
        return answer;
    }
}

public class 이진수더하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
