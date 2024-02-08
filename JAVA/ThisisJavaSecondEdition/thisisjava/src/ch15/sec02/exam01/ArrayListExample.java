package ch15.sec02.exam01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		List<Board> list = new ArrayList<>();

		list.add(new Board("title1","cont1","writter1"));
		list.add(new Board("title2","cont2","writter2"));
		list.add(new Board("title3","cont3","writter3"));
		list.add(new Board("title4","cont4","writter4"));
		list.add(new Board("title5","cont5","writter5"));
		
		int size = list.size();
		System.out.println("총 객체 수 : "+size);
		System.out.println();
		
		Board board = list.get(2);
		System.out.println(board.getSubject()+"\t"+board.getContent()+"\t"+board.getWriter());
		System.out.println();
		
		for(int i=0;i<list.size();i++) {
			Board b = list.get(i);
			System.out.println(b.getSubject()+"\t"+b.getContent()+"\t"+b.getWriter());
		}
		System.out.println();
		
		list.remove(2);
		list.remove(2);
		
		for(Board b:list) System.out.println(b.getSubject()+"\t"+b.getContent()+"\t"+b.getWriter());
	}

}
