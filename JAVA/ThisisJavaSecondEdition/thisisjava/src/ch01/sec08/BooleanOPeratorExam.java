package ch01.sec08;

class BooleanOPeratorExam{
	public static void main(String args[]){
		boolean  t=true ;
		boolean f=false;
		System.out.println("true&false="+(t&f)); //false
		System.out.println("true&true="+(t&t)); //true
		System.out.println("false&false="+(f&f)); //false
		System.out.println();
	
		System.out.println("true|false="+(t|f)); //true
		System.out.println("true|true="+(t|t));//true
		System.out.println("false|false="+(f|f));//false
		System.out.println();

		System.out.println("true^false="+(t^f)); //true
		System.out.println("true^true="+(t^t)); //false
		System.out.println("true^false="+(t^f));//true
		System.out.println("true^true="+(t^t));//false
		System.out.println();

		System.out.println("true&&false="+(t&&f)); //false
		System.out.println("true&&true="+(t&&t)); //true
		System.out.println("true&&false="+(t&&f)); //false
		System.out.println("false&&false="+(f&&f)); //false
		System.out.println();

		System.out.println("true||false="+(t||f)); //true
		System.out.println("true||true="+(t||t)); //true
		System.out.println("false||false="+(f||f)); //false
		System.out.println();

		int i=5; int j=3;
		System.out.println("int i="+i+"\tint j="+j); //true
		System.out.println("i>=j==>>"+(i>=j)); //true
		System.out.println("i>j=>>"+(i>j));//true
		System.out.println("i<=j=>>"+(i<=j));//false
		System.out.println("i<j=>>"+(i<j));//false
		System.out.println("i==j=>>"+(i==j));//false
		System.out.println("i!=j=>>"+(i != j));//true

	}
}
