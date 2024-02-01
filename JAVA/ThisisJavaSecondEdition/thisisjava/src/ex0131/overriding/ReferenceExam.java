package ex0131.overriding;

class ObjectExam{
	String str;
	
	public ObjectExam(){ }
	public ObjectExam(String str){
		this.str=str;
	}
	
	@Override
	public String toString() {
		return str + super.toString();
	}
}

class ReferenceExam{
	public static void main(String[] args){
			char c='a';
			String s01="홍길동"; 
			String s02="Java";
			String s03=new String("월요일");
			ObjectExam oe1=new ObjectExam("뭐먹지");
			ObjectExam oe2=new ObjectExam("안녕");
			System.out.println(c);//a
			
			//println() / print()는 Object가 전달되면, obj.toString()자동 호출
			//Object의 .toString()은 객체의 주소를 문자열로 리턴
			//String의 .toString()은 오버라이딩
			System.out.println(s01);//문자열
			System.out.println(s01.toString());//문자열
			System.out.println(s02);//문자열
			System.out.println(s03);//문자열
			
			System.out.println(oe1);//주소값
			System.out.println(oe2);//주소값
			
	}
}
