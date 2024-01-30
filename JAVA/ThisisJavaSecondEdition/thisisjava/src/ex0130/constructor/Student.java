package ex0130.constructor;

public class Student {
	private String name;
	private int age;
	private String addr;
	
	//Constructor
	public Student (String name,int age,String addr) {
		this(name,addr); //인수 2개 받는 생성자 호출
		this.age = age;
	}
	
	public Student(String name, String addr) {
		this.name = name;
		this.addr = addr;
	}
	
	public void setName(String name) {this.name=name;}
	public String getName() { return this.name;}
	
	public void setAge(int age)	{
		if (age>18) this.age=age;
	}
	public int getAge() {return this.age;}
	
	public void setAddr(String addr) {this.addr=addr;}
	public String getAddr() {return this.addr;}
}
