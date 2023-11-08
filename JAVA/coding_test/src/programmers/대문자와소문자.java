package programmers;

class Solution1 {
    public String solution(String my_string) {
        String answer = "";
        
        for(char a : my_string.toCharArray()){
            if (Character.isUpperCase(a)){
                answer += Character.toLowerCase(a);
            } else {
                answer += Character.toUpperCase(a);
            }
        };
        return answer;
    }
}

public class 대문자와소문자 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		System.out.println(s.solution("cccCCC"));
		System.out.println(s.solution("abCdEfghIJ"));
	}

}
