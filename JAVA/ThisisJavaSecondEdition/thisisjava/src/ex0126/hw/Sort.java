package ex0126.hw;

//선택,버블,삽입

public class Sort {
	
	public static int findMin(int[] array, int min) {
		for(int a: array) if(a<min) min = a;
		return min;
	}

	public static void main(String[] args) {
		int[] array = {5,7,1,2,4,3,8,9,6,10};
		
		//선택 정렬 : 최소값과 맨앞의 값을 비교하며 정렬
		int i =0;
		
		int min = array[0];
		array = array;
		for(int a: array) {
			if(a<min) {
				int temp;
				temp = min;
				min = a;
				a = temp;
			}
		}
		
//		if(min==array[0])
		System.out.println(java.util.Arrays.toString(array));
	}

}
