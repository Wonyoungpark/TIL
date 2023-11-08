package codeup;

import java.util.Scanner;

public class No1099 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[10][10];
		
		for(int j=0;j<10;j++) {
			for(int i=0;i<10;i++) {
				board[j][i]=sc.nextInt();
			}
		}
		
		int a=1;
		int b=1;
		while(true) {
			if(board[a][b]==2) {
				board[a][b]=9;
				break;
			}
			
			if(board[a][b+1]==1) {
				if(board[a+1][b]==1) break;
				else a++;
			}
			else if(board[a][b+1]!=1) b++;
			
			if(board[a][b]==2) {
				board[a][b]=9;
				break;
			}
			board[a][b]=9;
		}
		board[1][1]=9;
		
		for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                System.out.printf("%d ",board[i][j]);
            }
            System.out.print("\n");
        }
	}

}

// 참고 사이트 : https://yongku.tistory.com/entry/%EC%BD%94%EB%93%9C%EC%97%85-%EA%B8%B0%EC%B4%88-100%EC%A0%9C-1099%EB%B2%88-%EC%84%B1%EC%8B%A4%ED%95%9C-%EA%B0%9C%EB%AF%B8-%EC%9E%90%EB%B0%94JAVA