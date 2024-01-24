package ex0124.control;

public class SwitchExam01 {
	public static void main(String[] args) {
		int rand = (int) Math.random()*12+1;
		int day=31;
		
		switch (rand){
		case 2 -> day=28;
		case 4,6,9,11-> day=30;
		default -> day=31;
		}
		
		int endDay;
		endDay = switch (rand){
		case 2 -> 28;
		case 4,6,9,11-> {
			yield 30; //중괄호 때문에 yield 사용
		}
		default -> 31;
		};
		
		if (rand==2) day=28;
		else if (rand==4 || rand==6 || rand==9 || rand==11) day=30;
		else day=31;
		
		double score = 66/10;
		char grade = 'F';
		switch ((int)score) {
		case 9: grade='A'; break;
		case 8: grade='B'; break;
		case 7: grade='C'; break;
		case 6: grade='E'; break;
		}
		System.out.println(grade);
	}
}
