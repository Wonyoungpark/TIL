package ex0131.overriding;

//MethodOverridingExam.java
class SuperClass{
 	protected int intNumber;
 	protected String memberString="Sting in SuperClass";
 	
	SuperClass(){
 		System.out.println("생성자 SuperClass()가 호출되었습니다.");
 	}
 	
	public void methodZero(){
 		System.out.println("SuperClass객체의 methodZero()메소드가 호출되었습니다.");		
		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
	}
 	
 	protected void methodOwn(){
 		System.out.println("SuperClass객체의 methodOwn()메소드가 호출되었습니다.");		
		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
 	}
 	
	int methodTwo(int i){
 		intNumber=i;
 		System.out.println("SuperClass객체의 methodTwo()메소드가 호출되었습니다.");		
 		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
 		return intNumber;
 	}
 	
	protected String methodThree(int i, String s){
 		intNumber=i;
 		memberString=s;
 		System.out.println("SuperClass의 methodThree(int k,String str)가 호출되었습니다.");
 		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
 		return i+s;
 	}
 	
	public void methodFour(){
 		memberString="methodFour invokes methodOwn";
 		methodOwn();
 	}
}

/*overrriding기본 조건
	리턴타입, 메소드 이름, 인수가 동일
	modifier는 같거나 커야한다.
*/

class SubClass extends SuperClass{ //SubClass is SuperClass 성립
	SubClass(){
		memberString = "SubClass의 생성자가 입력한 String";
 		System.out.println("생성자 SubClass()가 호출되었습니다.");
 	}
 	
	public void methodZero(){	
	
 		System.out.println("SubClass의 methodZero()가 호출되었습니다.");
		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
	}
 	
	protected void methodOwn(){
		
 		System.out.println("SubClass의 methodOwn()가 호출되었습니다.");
 		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
// 		return intNumber; 
 	}
 	
	int methodTwo(int a){
	
 		intNumber=a;
 		System.out.println("SubClass의 methodTwo(int a)가 호출되었습니다.");
 		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
		return intNumber; 
 	}
 	String methodThree(String s, int k){
		intNumber=k;
 		memberString=s;
 		System.out.println("SubClass의 methodThree(String s, int k)가 호출되었습니다.");
 		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
 		return memberString;
 	}
	
	protected String methodThree(int k,String str){
	
 		intNumber=k;
 		memberString=str;
 		System.out.println("SubClass의 methodThree(int k,String str)가 호출되었습니다.");
 		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
 		return memberString;
 	}
 	
	public void methodFour(){
	
 		System.out.println("SubClass의 public double methodFour()가 호출되었습니다.");
 		memberString="methodFour invokes methodOwn";
 		methodOwn();
 	}
}

class MethodOverridingExam{
	public static void main(String [] args){
		SuperClass sp = new SuperClass();
		System.out.println("**************************************");
		SubClass sb = new SubClass();		
		System.out.println("**************************************");
		
//		sp.methodZero();
//		sp.methodOwn();
//		sp.methodTwo(2);
//		sp.methodThree(3, "MethodOverridingExam.java");
//		sp.methodFour();
//		System.out.println("**************************************");
//		
//		sb.methodZero();
//		sb.methodOwn();
//		sb.methodTwo(2222);
//		sb.methodThree(3333, " MethodOverridingExam.java");
//		sb.methodFour();	
	}
}					
