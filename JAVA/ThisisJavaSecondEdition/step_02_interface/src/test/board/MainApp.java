package test.board;

public class MainApp {
	private BoardService boardService; //필드 통한 다형성
	private Board board; //필드 통한 다형성
	
	public MainApp() {
		//QA
		System.out.println("qa test");
		board = new QABoard(1,"java","희정","어렵다",false);
		boardService = new QABoardServiceImpl();
		this.test(boardService, board);
		
		//Upload
		System.out.println("upload test");
		board = new UploadBoard(2,"주말","삼순이","좋아요","a.jpg");
		boardService = new UploadBoardServiceImpl();
		this.test(boardService, board);
		
		//Free
		System.out.println("free test");
		board = new FreeBoard(30,"다형성","삼순","어려워요.");
		boardService = new FreeBoardServiceImpl();
		test(boardService,board);
	}
	
	//매개변수를 이용하는 다형성
	public void test(BoardService boardService, Board board) {
		//등록
		int result = boardService.insert(board);
		
		//수정
		boolean b = boardService.update(board);
		
		//검색
		Board search = boardService.selectBno(board.getBno());

		//추가된 메소드 호출
		boardService.replyInsert();
		//static 메소드 호출 //구현객체 없이 바로 접근 가능
		BoardService.selectAll();//단, 오버라이딩 기능이 아님, 그냥 고정 후 사용
	}
	
	public static void main(String[] args) {
		System.out.println("Test start====");
		new MainApp();
	}
}
