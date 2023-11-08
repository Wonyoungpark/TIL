package programmers;

class Solution22 {
    public int solution(int[] numbers) {
        int answer = numbers[0]*numbers[1];
        
        for (int i=0;i<numbers.length;i++){
            for (int j=i+1;j<numbers.length;j++){
                int num = numbers[i]*numbers[j];
                if (num>answer) answer = num;
            }
        }
        return answer;
    }
}

public final class 최댓값만들기2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
