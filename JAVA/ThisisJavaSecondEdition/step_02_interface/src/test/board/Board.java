package test.board;

//게시물의 공통 속성 객체

public class Board {
	private int bno;
	private String subject;
	private String writter;
	private String content;
	
	public Board() {}

	public Board(int bno, String subject, String writter, String content) {
		super();
		this.bno = bno;
		this.subject = subject;
		this.writter = writter;
		this.content = content;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWritter() {
		return writter;
	}

	public void setWritter(String writter) {
		this.writter = writter;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [bno=");
		builder.append(bno);
		builder.append(", subject=");
		builder.append(subject);
		builder.append(", writter=");
		builder.append(writter);
		builder.append(", content=");
		builder.append(content);
		builder.append(", ");
		return builder.toString();
	}
	
}
