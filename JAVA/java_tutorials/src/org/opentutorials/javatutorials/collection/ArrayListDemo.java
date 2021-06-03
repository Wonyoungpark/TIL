package org.opentutorials.javatutorials.collection;
import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		String[] arrayObj = new String[2];
		arrayObj[0] = "one";
		arrayObj[1] = "two";
//		arrayObj[2] = "three";
		
		for(int i=0; i<arrayObj.length; i++) {
			System.out.println(arrayObj[i]);
		}
		
		ArrayList <String> al = new ArrayList<String>();
		al.add("one"); // 인자의 데이터타입은 object
		al.add("two");
		al.add("three");
		
		for(int i=0; i<al.size(); i++) {
//			String value = (String)al.get(i); // object에서 String으로 형변환
			String value = al.get(i);
			System.out.println(value);
		}
	}

}
