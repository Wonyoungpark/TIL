package Programmers.daily.java_study;

class Solution4 {
    public int solution(int order) {
        int answer = 0;
        String str = Integer.toString(order);
        
        for(char s : str.toCharArray()){
            if(s=='3'||s=='6'||s=='9') answer ++;
        }
        return answer;
    }
}

class ₩369게임 {

	public static void main(String[] args) {
		Solution4 s  = new Solution4();
		System.out.println(s.solution(3));
		System.out.println(s.solution(29423));

	}

}
