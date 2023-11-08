package programmers;

//import java.util.Queue;
//import java.util.LinkedList;
//import java.util.*;

//class Solution {
//  public int solution(int[][] lines) {
//      int answer = 0;
//      Queue<Integer> queue = new LinkedList<Integer>();
//      Arrays.sort(lines,(a,b)->{return a[0]-b[0];});
     
//      int end = 0;
//      for(int[] l : lines){
//          if (queue.isEmpty()){
//              queue.offer(l[0]);
//              end = l[1];
//          } else {
//              if (l[0] < end && l[0]>=queue.peek()){
//                  System.out.println(l[0]);
//                  answer += end - l[0];
                 
//                  end = Math.max(l[1],end);
//              } else {
//                  end = l[1];
//              }
//              queue.poll();
//              queue.offer(l[0]);
//          }
//      }
//      return answer;
//  }
//}

class Solution14 {
 public int solution(int[][] lines) {
     int[] arr = new int[200];
     int answer = 0;
     
     for (int[] line : lines) {
         int a = line[0] + 100;
         int b = line[1] + 100;
         while (a<b) {
             if (++arr[a++] == 2) answer++;
         }
     }
     return answer;
 }
}

public class 겹치는선분의길이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// 참고 사이트 : https://nahwasa.com/entry/자바-프로그래머스-겹치는-선분의-길이-Lv0-Java