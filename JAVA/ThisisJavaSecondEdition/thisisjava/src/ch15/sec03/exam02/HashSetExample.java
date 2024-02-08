package ch15.sec03.exam02;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		//HashSet컬렉션 생성
		Set<Member> set = new HashSet<Member>();

		set.add(new Member("홍길동",30));
		set.add(new Member("홍길동",30));
		
		System.out.print(set.size());
	}

}
