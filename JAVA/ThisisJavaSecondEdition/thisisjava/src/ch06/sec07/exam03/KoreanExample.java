package ch06.sec07.exam03;

public class KoreanExample {

	public static void main(String[] args) {
//		Korean객체 생성
		Korean k1 = new Korean("박자바","0111223-345678");
		//Korean객체 데이터 읽기
		System.out.println("k1.nation: "+k1.nation);
		System.out.println("k1.name: "+k1.name);
		System.out.println("k1.ssn: "+k1.ssn);
		
		//다른 Korean 객체 생성
		Korean k2 = new Korean("김자바","0222233-345678");
		
	}

}
