package ex0201.hw;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		System.out.println("EMP 정보******");	
//		FullTime ft1 = new FullTime(10, "유재석", "개그우먼", 0 , "2013-05-01", "무한도전",8500,200);
//		FullTime ft2 = new FullTime(20, "박명수", "가수",10, "2013-06-20", "무한도전",7500,100);
//		FullTime ft3 = new FullTime(30, "정준하", "예능인",10 , "2013-06-22", "무한도전",6000,0);
//		Object[] full = {ft1,ft2,ft3};
//		
//		PartTime pt1 = new PartTime(40, "노홍철", "예능인",20 , "2014-05-01", "무한도전",20000);
//		PartTime pt2 = new PartTime(50, "하하", "가수",30 , "2014-05-02", "무한도전",25000);
//		Object[] part = {pt1,pt2};
//		
//		for(Object f:full) System.out.println(f);
//		for(Object p:part) System.out.println(p);
//
//		System.out.println("\nEMP Message 정보******");
//		for(Object f:full) ((FullTime) f).message();
//		for(Object p:part) ((PartTime) p).message();
		
		Employee emp[] = new Employee[5];

		emp[0] = new FullTime(10, "유재석", "개그우먼", 0 , "2013-05-01", "무한도전",8500,200);
		emp[1] = new FullTime(20, "박명수", "가수",10, "2013-06-20", "무한도전",7500,100);
		emp[2] = new FullTime(30, "정준하", "예능인",10 , "2013-06-22", "무한도전",6000,0);
		emp[3] = new PartTime(40, "노홍철", "예능인",20 , "2014-05-01", "무한도전",20000);
		emp[4] = new PartTime(50, "하하", "가수",30 , "2014-05-02", "무한도전",25000);
		
		System.out.println("EMP 정보******");	
		for(Employee e:emp) System.out.println(e.toString());
		
		System.out.println("\nEMP Message 정보******");
		for(Employee e:emp) e.message();

	}

}
