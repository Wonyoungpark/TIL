package test.board;

public class UploadBoard extends Board {
	private String file;
	
	public UploadBoard() {}

	public UploadBoard(int bno, String subject, String writter, String content,String file) {
		super(bno, subject, writter, content);
		this.file = file;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(file);
		builder.append("]");
		return builder.toString();
	}
	
	
}
