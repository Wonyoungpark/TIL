package ch06.sec11.exam01;

public class KoreanExample {

	public static void main(String[] args) {
		// 객체 생성 시 주민등록번호와 이름 전달
		Korean k1 = new Korean("123456-1234567","홍길동");
		
		//필드값 읽기
		System.out.println(k1.name);
		System.out.println(k1.nation);
		System.out.println(k1.ssn);
		
		//final은 필드값 변경 불가
//		k1.nation="rkdks";
//		k1.ssn="123";
		
		//final 필드 외에는 변경 가능
		k1.name="asf";
	}

}
