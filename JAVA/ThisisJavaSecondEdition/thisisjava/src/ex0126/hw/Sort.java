package ex0126.hw;

import java.util.Arrays;

public class Sort {
	
	public static int findMin(int[] array, int min) {
		for(int i=min+1;i<array.length;i++) if(array[i]<array[min]) min = i;
		return min;
	}
	
	public static void switchTwo(int[] array,int min,int i) {
		int temp = array[i];
		array[i] = array[min];
		array[min] = temp;
	}

	public static void main(String[] args) {
		int[] array = {5,7,1,2,4,3,8,9,6,10};
		//선택 정렬 : 최소값과 맨앞의 값을 비교하며 정렬
		int min;
		for(int i=0;i<array.length-1;i++) {
			min = findMin(array,i);
			switchTwo(array,min,i);
		}
		System.out.println(Arrays.toString(array));
		

		int[] array2 = {5,7,1,2,4,3,8,9,6,10};
		//버블 정렬 : k번째 원소와 k+1번째 원소를 비교하며 정렬
		for(int i=0;i<array2.length-1;i++) {
			for(int j=0;j<array2.length-1;j++) {
				if(array2[j]>array2[j+1]) switchTwo(array2,j+1,j);
			}
		}
		System.out.println(Arrays.toString(array2));
		
		

		int[] array3 = {5,7,1,2,4,3,8,9,6,10};
		//삽입 정렬 : 타겟(두번째 원소)와 이전 원소를 비교하며 정렬
		for(int i=0;i<array3.length-1;i++) {
			int target = i+1;
			for(int j=0;j<target;j++)
				if(array3[j]>array3[target]) switchTwo(array3,target,j);
		}
		System.out.println(Arrays.toString(array3));
	}

}
