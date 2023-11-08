package programmers;

class Solution3 {
    public String solution(String cipher, int code) {
        String answer = "";
        
        for(int i=code-1; i<cipher.length(); i += code){
            answer += cipher.charAt(i);
        }
        return answer;
    }
}

public class 암호해독 {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		System.out.println(s.solution("dfjardstddetckdaccccdegk", 4));
		System.out.println(s.solution("pfqallllabwaoclk", 2));

	}

}
