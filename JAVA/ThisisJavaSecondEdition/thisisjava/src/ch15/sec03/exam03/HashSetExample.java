package ch15.sec03.exam03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("JSP");
		set.add("Spring");
		
		//객체를 하나씩 가져와서 정리
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			//객체 한개씩 가져오기
			String element = iterator.next();
			System.out.println(element);
			if(element.equals("JDBC")) iterator.remove();
		}
		System.out.println();
		
		set.remove("JSP");
		
		for(String element:set) System.out.println(element);
	}

}
