package test.board;

//자유게시판 속성 객체
public class FreeBoard extends Board {
	public FreeBoard() {}

	public FreeBoard(int bno, String subject, String writter, String content) {
		super(bno, subject, writter, content);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
