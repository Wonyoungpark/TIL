package ch15.sec03.exam01;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		//HashSet 컬렉션 생성
		Set<String> set = new HashSet<String>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("JSP");
		set.add("Java"); //중복객체이므로 저장 안함
		set.add("Spring");
		
		int size = set.size();
		System.out.println("총 객체 수 : "+size);
	}

}
