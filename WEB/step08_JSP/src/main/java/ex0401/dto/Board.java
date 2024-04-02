package ex0401.dto;

public class Board {
    private int no;
    private String subject;
    private String content;

    public Board() {
    }

    public Board(int no, String subject, String content) {
        this.no = no;
        this.subject = subject;
        this.content = content;
    }

    public int getNo() {
        return no;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }
}
