package ex0129.array.hw;

public class Student {
	private String name;
	private int age;
	private String addr;
	
	public void setName(String name) {this.name=name;}
	public String getName() { return this.name;}
	
	public void setAge(int age)	{
		if (age>18) this.age=age;
	}
	public int getAge() {return this.age;}
	
	public void setAddr(String addr) {this.addr=addr;}
	public String getAddr() {return this.addr;}
}
