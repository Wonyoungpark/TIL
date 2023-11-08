package programmers;

class Solution20 {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        int i =0;
        
        for (String str:strlist){
            answer[i] = str.length();
            i++;
        }
        return answer;
    }
}

public class 배열원소의길이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
