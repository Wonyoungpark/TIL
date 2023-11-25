package baekjoon;

//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class No1157 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
//		str = str.toUpperCase();
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		
//		for(String c: str.split("")) {
//			if (map.containsKey(c)) map.put(c, map.get(c)+1);
//			else map.put(c,1);
//		}
//		
//		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
//		Collections.sort(list, new Comparator<>() {
//			@Override
//			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String,Integer> o2) {
//				return o2.getValue().compareTo(o1.getValue());
//			}
//		});
//		System.out.println(list.get(0));
//
//	}
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[26];
		String str = br.readLine();
		
		for(int i=0;i<str.length();i++) {
			if('a'<= str.charAt(i) && str.charAt(i) <= 'z') { // 소문자 범위일 경우
				arr[str.charAt(i)-97]++;
			} else arr[str.charAt(i)-65]++; // 대문자 범위일 경우
		}
		
		int max = -1;
		char c = '?';
		for(int i=0;i<26;i++) {
			if(arr[i]>max) {
				max = arr[i];
				c = (char)(i+65);
			} else if(arr[i]==max) c = '?'; // 많이 나온 알파벳이 중복일 경우
		}
		
		System.out.println(c);
	}
}