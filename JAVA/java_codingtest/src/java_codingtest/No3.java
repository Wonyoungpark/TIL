package java_codingtest;

public class No3 {

	public static void main(String[] args) {
		int[] arr = {15,80,15,19,78,23,5,30,10,47};
		
		for (int i=1;i<arr.length;i++) {
			int stand = arr[i];
			int pre = i-1;
			
			while(pre>=0 && stand<arr[pre]) {
				arr[pre+1] = arr[pre]; //자리바꿈
				pre--;
			}
			arr[pre+1] = stand;
		}
		for (int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+ " ");
		}
	}
}
