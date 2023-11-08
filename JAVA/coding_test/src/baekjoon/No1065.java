package baekjoon;

import java.util.Scanner;
import java.util.stream.Stream;

public class No1065 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int result = 0;
		
		while(num>0) {
			int[] arr = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();

			if(arr.length <= 2) {
				result += num;
				break;
			}

			else {
				result += cntnum(arr);
			}
			
			num--;
		}
		System.out.println(result);
	}
	
	static int cntnum(int[] arr) {
		int result=0;
		int dif = arr[1]-arr[0];
		for(int i=(arr.length-1);i>0;i--) {
			int cnt=0;
			if(dif == (arr[i]-arr[i-1])) {
				cnt++;
			}
			else break;
			if(cnt==arr.length-2) {
				result++;
				break;}
		}
		return result;
	}

}
