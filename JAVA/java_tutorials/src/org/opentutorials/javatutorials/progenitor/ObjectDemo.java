package org.opentutorials.javatutorials.progenitor;

class Student{
	String name;
	Student(String name){
		this.name = name;
	}
	public Boolean eqauls(Object obj) {
		return true;
	}
}

class ObjectDemo {

	public static void main(String[] args) {
		Student s1 = new Student("holly");
		Student s2 = new Student("holly");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
	}

}
