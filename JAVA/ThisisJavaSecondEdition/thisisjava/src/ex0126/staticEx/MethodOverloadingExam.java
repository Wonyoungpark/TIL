package ex0126.staticEx;

//MethodOverloadingExam.java
class OverloadedMethod{
	private int i; //전역 필드, 0초기화, 은닉되어있음(외부 접근 불가)
       
	public void  setOverload(int i){
		this.i = i; //this->전역필드 //전달된 인수의 값을 전역필드에 넣어라
	}
	
	public int getOverload(){
		return i;
	}
	
	//setOverload를 Overloading하고 리턴.
	private int setOverload(String s) { return this.i;}
	
	//setOverload를 Overloading 다르게 리턴
	public int setOverload(double d) { return this.i;}
	
	//setOverload를 Overloading 다르게 리턴없음
	private void setOverload() {}
	
	

	//getOverload를 Overloading하고 리턴.
	public int getOverload(String s) { return this.i;}
	
	//getOverload를 Overloading 다르게 리턴
	public int getOverload(double d) { return this.i;}
	
	//getOverload를 Overloading 다르게 리턴없음
	public void getOverload(int i) { }

	
}

class  MethodOverloadingExam{
       
  public static void main(String [] agr){
     //OverloadedMethod겍체에서 호출 가능한 메소드 호출
	}   


}

