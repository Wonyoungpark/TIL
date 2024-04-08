package kosta.dto;

public class BoardDTO {
   private int no; //글번호
   private String subject;//제목
   private String content; //내용
   
   public BoardDTO() {}
   public BoardDTO(int no, String subject, String content) {
	super();
	this.no = no;
	this.subject = subject;
	this.content = content;
  }
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
   
}
