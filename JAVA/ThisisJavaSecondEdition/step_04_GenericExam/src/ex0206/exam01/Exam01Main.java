package ex0206.exam01;

class Board {}

public class Exam01Main {

	public static void main(String[] args) {
		Box<String> box01 = new Box<String>();
		box01.content="새우깡";
		
		Box<Integer> box02 = new Box<Integer>(); //Wrapper 클래스
		box02.content = 1000;
		
		Box<Board> box3 = new Box<Board>();
		box3.content = new Board();
	}

}
