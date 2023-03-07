package Programmers.daily.java_study;

//import java.util.Arrays;

class Solution19 {
 public int solution(int[][] board) {
     int answer = 0;
     int n = board.length;
     boolean[][] danger = new boolean[n][n];
     
     int[] dx = {-1,0,1,0,-1,1,-1,1};
     int[] dy = {0,1,0,-1,-1,-1,1,1};
     
     for (int i=0;i<n;i++){
         for (int j=0;j<n;j++){
//              if (board[i][j]==1){
//                  try {
//                      danger[i][j] = true;
//                      if (i>=1) {
//                          danger[i-1][j]=true;
//                          danger[i-1][j+1]=true;
//                      }
//                      if (j>=1){
//                          danger[i][j-1]=true;
//                          danger[i+1][j-1]=true;
//                          System.out.println(danger[i][j-1]);
//                      }
                     
//                      if(i>=1&&j>=1) danger[i-1][j-1]=true;
                     
//                      danger[i][j+1]=true;
//                      danger[i+1][j]=true;
//                      danger[i+1][j+1]=true;
//                  } catch (ArrayIndexOutOfBoundsException e) {
//                      continue;
//                  }
//              }
             
             for (int k=0;k<8;k++){
                 int nx = i+dx[k];
                 int ny = j+dy[k];
                 if(board[i][j]==1) danger[i][j] = true;
                 if (nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==1) danger[i][j] = true;
             }
         }
     }
     
     for (boolean[] dang:danger){
         for (boolean d:dang){
             if (d==false) answer++;
         }
     }
     return answer;
 }
}

public class 안전지대 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// 참고 사이트 : https://tevelop.tistory.com/44