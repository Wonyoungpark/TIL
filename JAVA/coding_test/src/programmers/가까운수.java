package programmers;

class Solution2 {
    public int solution(int[] array, int n) {
        int answer = array[0];
        int num = Math.abs(array[0]-n);
        
        for (int a : array){
            if (num>Math.abs(a-n)){
                num = Math.abs(a-n);
                answer = a;
            } else if (num == Math.abs(a-n)){
                answer = Math.min(answer,a);
            }
        }
        return answer;
    }
}

public class 가까운수 {

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int[] arr = {3,10,28};
		System.out.println(s.solution(arr, 20));
		int[] arr1 = {10, 11,12};
		System.out.println(s.solution(arr1, 13));
	}

}
