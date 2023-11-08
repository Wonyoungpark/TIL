package programmers;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution12 {
    public Integer[] solution(int[] numlist, int n) {
//         int[] answer = new int[numlist.length];
//         List<Integer> nlist = new ArrayList<>();
        
//         for (int a : numlist){
//             nlist.add(n-a);
//             System.out.println(Math.abs(nlist.indexOf[1]));
//         }
//         Collections.sort(nlist);
        
//         int i = 0;
//         for (int l : nlist){
//             int idx = nlist.indexOf(l);
//             answer[i] = numlist[idx];
//             i++;
//         }
//         return answer;
        
        
        List<Integer> solution = IntStream.of(numlist).boxed().collect(Collectors.toList());

        
        solution.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int aAbs = Math.abs(a-n);
                int bAbs = Math.abs(b-n);
                
                if (aAbs==bAbs){
                    if(a>b) return -1;
                    else if (a<b) return 1;
                } else return aAbs-bAbs;
                
                return 0;
            }
        });
        return solution.toArray(new Integer[0]);
    }
}

public class 특이한정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// 참고 사이트 : https://velog.io/@as9587/프로그래머스-코딩테스트-입문-특이한-정렬-JAVA-22년-10월-14일