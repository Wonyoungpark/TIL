package exam;

import java.util.Scanner;

public class EncapsulationExam {
	int weight;
	String pwd;
	
	public EncapsulationExam(int weight, String pwd) {
		this.weight = weight;
		this.pwd = pwd;
	}

	public int getWeight(String pwd) {
		if(this.isPwd(pwd)) System.out.println("몸무게 : "+this.weight);
		else System.out.println("비밀번호 불일치"+pwd);
		return this.weight;
	}
	
	public void setWeight(int weight, String pwd) {
		if(this.isPwd(pwd)) this.weight=weight;
	}
	
	public void setPwd(String old,String neww) {
		if(this.isPwd(old)) this.pwd = neww;
	}
	
	private boolean isPwd(String pwd) {
		if(this.pwd.equals(pwd)) return true;
		else return false;
//		return this.pwd.equals(pwd);
	}

	public static void main(String args [] ) {
		Scanner sc = new Scanner(System.in);
		boolean run=true;
		System.out.println("몸무게 설정> ");
		int weight = sc.nextInt();
		System.out.println("비밀번호 설정> ");
		String pwd = sc.next();
		EncapsulationExam ex = new EncapsulationExam(weight,pwd);
		
		while(run) {
			
			System.out.println("---------------------------------------------------------------------");
			System.out.println("1.몸무게 검색  | 2.몸무게 변경   | 3. 비밀번호 변경  |  9.종료");
			System.out.println("---------------------------------------------------------------------");
			System.out.print("선택> ");
			int n = sc.nextInt();
			
			if(n==1) {
				System.out.print("비밀번호를 입력하세요");
				pwd = sc.next();
				ex.getWeight(pwd);
			} else if(n==2) {
				System.out.print("비밀번호를 입력하세요");
				pwd = sc.next();
				System.out.print("변경할 몸무게를 입력하세요");
				weight = sc.nextInt();
				ex.setWeight(weight, pwd);
			} else if(n==3) {
				System.out.print("기존 비밀번호를 입력하세요");
				String old = sc.next();
				System.out.print("변경할 비밀번호를 입력하세요");
				String neww = sc.next();
				ex.setPwd(old, neww);
			} else if(n==9) System.exit(0);
		}
	}
}
