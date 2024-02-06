package ex0206.exam06;

public class Exam06Main {

	public static void main(String[] args) {
		Course course = new Course();
		course.register1(new Applicant<Person>(new Person()));
		course.register1(new Applicant<Worker>(new Worker()));
		course.register1(new Applicant<Student>(new Student()));
		course.register1(new Applicant<MiddleStudent>(new MiddleStudent()));
		course.register1(new Applicant<HighStudent>(new HighStudent()));
		
		System.out.println("<? super Worker> ----------------");
		
		course.register2(new Applicant<Person>(new Person()));
		course.register2(new Applicant<Worker>(new Worker()));
//		course.register2(new Applicant<Student>(new Student()));
//		course.register2(new Applicant<MiddleStudent>(new MiddleStudent()));
//		course.register2(new Applicant<HighStudent>(new HighStudent()));

		System.out.println("<? extends Student> ----------------");

//		course.register3(new Applicant<Person>(new Person()));
//		course.register3(new Applicant<Worker>(new Worker()));
		course.register3(new Applicant<Student>(new Student()));
		course.register3(new Applicant<MiddleStudent>(new MiddleStudent()));
		course.register3(new Applicant<HighStudent>(new HighStudent()));
	}

}
