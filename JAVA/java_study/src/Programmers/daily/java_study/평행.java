package Programmers.daily.java_study;

class Solution15 {
    // 기울기
    public double depth(int[] d1, int[] d2) {
        return (double) (d1[1]-d2[1])/(d1[0]-d2[0]);
    }
    
    public int solution(int[][] dots) {
        int answer = 0;
        
        if (depth(dots[0],dots[1]) == depth(dots[2],dots[3])) return 1;
        if (depth(dots[0],dots[2]) == depth(dots[1],dots[3])) return 1;
        if (depth(dots[0],dots[3]) == depth(dots[2],dots[1])) return 1;
        
        return answer;
    }
}

public class 평행 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
