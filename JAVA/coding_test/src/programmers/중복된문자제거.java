package programmers;

class Solution5 {
    public String solution(String my_string) {
        String answer = "";
        String[] arr = my_string.split("");
        for(String i : arr){
            if (!answer.contains(i)) answer += i;
        }
        return answer;
    }
}

public class 중복된문자제거 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
