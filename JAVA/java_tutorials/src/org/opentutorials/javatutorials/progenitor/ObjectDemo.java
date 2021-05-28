package org.opentutorials.javatutorials.progenitor;

class Student implements Cloneable{
	String name;
	Student(String name){
		this.name = name;
	}
//	public Boolean eqauls(Object obj) {
//		Student s = (Student)obj;
//		return this.name == s.name;
//	}
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class ObjectDemo {

	public static void main(String[] args) {
		Student s1 = new Student("holly");
//		Student s2 = new Student("holly");
//		System.out.println(s1 == s2);
//		System.out.println(s1.equals(s2));
		
		try {
			Student s2 = (Student)s1.clone();
			System.out.println(s1);
			System.out.println(s2);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
