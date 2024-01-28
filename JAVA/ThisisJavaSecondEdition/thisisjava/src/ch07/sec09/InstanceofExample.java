package ch07.sec09;

public class InstanceofExample {

	public static void personInfo(Person person) {
		System.out.println("name: "+person.name);
		person.walk();
		
		if(person instanceof Student student) {
			System.out.println("studentNO: "+student.studentNo);
			student.study();
		}
	}
	
	public static void main(String[] args) {
		Person p1 = new Person("홍길동");
		personInfo(p1); //Person은 Student로부터 생성x
		
		Person p2 = new Student("김길동",10);
		personInfo(p2);
	}

}
