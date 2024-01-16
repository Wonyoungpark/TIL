package ch04.sec03;

public class SwitchExample {

	public static void main(String[] args) {
		int num = (int)(Math.random()*6)+1; //주사위 번호 하나 뽑기
		
		switch(num) {
		case 1:
			System.out.println("1번이 나왔습니다.");
			break;
		case 2:
			System.out.println("2번이 나왔습니다.");
			break;
		}
	}

}
