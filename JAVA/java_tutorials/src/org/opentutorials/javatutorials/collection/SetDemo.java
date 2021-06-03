package org.opentutorials.javatutorials.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;

public class SetDemo {

	public static void main(String[] args) {
		HashSet<Integer> A = new HashSet<Integer>(); // HashSet 중복값은 저장 안됨, 고유값만 저장
		A.add(1);
		A.add(2);
		A.add(3);
		
		HashSet<Integer> B = new HashSet<Integer>();
		B.add(3);
		B.add(4);
		B.add(5);
		
		HashSet<Integer> C = new HashSet<Integer>();
		C.add(1);
		C.add(2);
		
		// 부분집합
		System.out.println(A.containsAll(B));
		System.out.println(A.containsAll(C));
//		A.addAll(B);	// 합집합
//		A.retainAll(B);	// 교집합
//		A.removeAll(B);	// 차집합
		
		// 반복
		Iterator hi = (Iterator) A.iterator();
		while(hi.hasNext()) {
			System.out.println(hi.next());
		}
		
		ArrayList<Integer> D = new ArrayList<Integer>(); // HashSet 중복값은 저장 안됨, 고유값만 저장
		D.add(1);
		D.add(2);
		D.add(3);
		
		Iterator li = D.iterator();
		while(li.hasNext()) {
			System.out.println(li.next());
		}
	}

}
