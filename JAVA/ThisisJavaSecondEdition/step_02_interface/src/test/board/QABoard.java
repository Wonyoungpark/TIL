package test.board;

//QA 관리 객체

public class QABoard extends Board {
	private boolean replyState; //false
	
	public QABoard() {}

	public QABoard(int bno, String subject, String writter, String content,boolean replyState) {
		super(bno, subject, writter, content);
		this.replyState = replyState;
	}

	public boolean isReplyState() {
		return replyState;
	}

	public void setReplyState(boolean replyState) {
		this.replyState = replyState;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("replyState=");
		builder.append(replyState);
		builder.append("]");
		return builder.toString();
	}
}
