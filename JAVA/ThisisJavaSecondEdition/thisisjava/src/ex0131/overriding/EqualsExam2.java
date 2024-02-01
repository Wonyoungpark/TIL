package ex0131.overriding;

class EqualsExam2{
	String stringObject;
	
	public EqualsExam2(String s){
		stringObject = s;
	}
	
	//equals()재정의한다면, 오버라이딩을 통해서 리턴값 변경
	@Override
	public boolean equals(Object obj) { //인수로 받은 obj는 EqualsExam2의 부모-> 자식으로 강제타입변환필요
		if(obj instanceof EqualsExam2) {
			EqualsExam2 ee = (EqualsExam2)obj;
			if (stringObject.equals(ee.stringObject))
				return true;
		}
		return false;
	}
	
	
	public static void main(String args[]){		
		System.out.println("\nEqualsExam ee1 = new EqualsExam(\"Object.equals()\");" );
		System.out.println("\nEqualsExam ee2 = new EqualsExam(\"Object.equals()\");" );
				
		EqualsExam2 ee1 = new EqualsExam2("Object.equals()");
		EqualsExam2 ee2 = new EqualsExam2("Object.equals()");
		
		if(ee1.equals(ee2)){
			System.out.println("ee1.equals(ee2) = true");
		}else{
			System.out.println("ee1.equals(ee2) = false");
		}//true->false
		
		if(ee1 == ee2){
			System.out.println("(ee1 == ee2) = true");
		}else{
			System.out.println("(ee1 == ee2) = false");
		}//false
		
		System.out.println("\nString s1 = \"new String Object1\";");
		System.out.println("\nString s2 = \"new String Object1\";");
		
		String s1 = "new String Object1";
		String s2 = "new String Object1";
		
		if(s1.equals(s2)){
			System.out.println("s1.equals(s2) = true");
		}else{
			System.out.println("s1.equals(s2) = false");
		}//true
		
		if(s1==s2){ //new 키워드를 사용하지 않았기 때문에 같은 주소에 저장
			System.out.println("(s1==s2) = true");
		}else{
			System.out.println("(s1==s2) = false");
		}//false->true

		System.out.println("\nString s3 = new String(\"new String Object2\");");
		System.out.println("\nString s4 = new String(\"new String Object2\");");
 
 		String s3 = new String("new String Object2");
		String s4 = new String("new String Object2");
		
		if(s3.equals(s4)){
			System.out.println("s3.equals(s4) = true");
		}else{
			System.out.println("s3.equals(s4) = false");
		}//true
		
		if(s3==s4){ //new 키워드를 사용해서 다른 주소에 저장
			System.out.println("(s3==s4) = true");
		}else{
			System.out.println("(s3==s4) = false");
		}//false

		System.out.println("\nString s5 = new String(\"new String Object3\");");
		System.out.println("\nString s6 = \"new String Object3\";");
		System.out.println("\nString s7 = \"new String Object3\";");
 
 		String s5 = new String("new String Object3");
		String s6 = "new String Object3";
		String s7 = "new String Object3";
		
		if(s5.equals(s6)){
			System.out.println("s5.equals(s6) = true");
		}else{
			System.out.println("s5.equals(s6) = false");
		}//false->true
		
		if(s5==s6){
			System.out.println("(s5==s6) = true");
		}else{
			System.out.println("(s5==s6) = false");
		}//false

			
		if(s6.equals(s7)){
			System.out.println("s6.equals(s7) = true");
		}else{
			System.out.println("s6.equals(s7) = false");
		}//true
		
		if(s6==s7){
			System.out.println("(s6==s7) = true");
		}else{
			System.out.println("(s6==s7) = false");
		}//false
	}
}