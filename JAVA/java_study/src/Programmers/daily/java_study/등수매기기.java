package Programmers.daily.java_study;

import java.util.*;

class Solution11 {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        List<Integer> avgList = new ArrayList<>();
        
        for (int[] t: score) {
            avgList.add(t[0]+t[1]);
        }
        avgList.sort(Comparator.reverseOrder());
        
        for(int i=0;i<score.length;i++){
            answer[i] = avgList.indexOf(score[i][0] + score[i][1])+1;
        }
        return answer;
    }
}

public class 등수매기기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// 참고 사이트 : https://velog.io/@ro_sie/프로그래머스-JAVA-등수-매기기